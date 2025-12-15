package com.lingfeng.camundastudy.service.camunda;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lingfeng.camundastudy.common.constant.CommonStateCode;
import com.lingfeng.camundastudy.common.exception.BizException;
import com.lingfeng.camundastudy.common.util.SecurityUtil;
import com.lingfeng.camundastudy.common.util.StrUtils;
import com.lingfeng.camundastudy.dao.repo.UserRepo;
import com.lingfeng.camundastudy.domain.dto.camunda.TaskDto;
import com.lingfeng.camundastudy.domain.entity.UserEntity;
import jakarta.annotation.Resource;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.task.TaskQuery;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WorkflowService {

    @Resource
    private RuntimeService runtimeService;
    @Resource
    private TaskService taskService;

    @Resource
    private RepositoryService repositoryService; // 新增
    @Resource
    private HistoryService historyService; // 新增
    @Resource
    private UserRepo userRepo; // 新增

    /**
     * 1. 统一流程启动接口
     * @param processKey 流程定义Key (如 process_leave)
     * @param businessKey 业务主键ID (如 请假单ID)
     * @param variables 流程变量
     * @return 流程实例ID
     */
    @Transactional(rollbackFor = Exception.class)
    public String startProcess(String processKey, String businessKey, Map<String, Object> variables) {
        // 校验：必须传入 BusinessKey
        if (StrUtils.isBlank(businessKey)) {
            throw new BizException(CommonStateCode.BUSINESS_KEY_NOT_EXIST);
        }

        // 启动流程
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(processKey, businessKey, variables);
        return instance.getId();
    }

    /**
     * 2. 查询“我的待办” (包含：直接指派给我的 + 我所属角色的组任务)
     */
    public IPage<TaskDto> getTodoTasks(int pageNum, int pageSize) {
        UserDetails user = SecurityUtil.getCurrentUser();
        if (user == null) {
            return new Page<>();
        }
        String userId = user.getUsername();
        // 获取用户角色 (如 "ROLE_ADMIN", "ROLE_USER")
        List<String> groupIds = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                // 如果你的 RoleEnum 里存的是 "ADMIN"，这里可能需要处理一下前缀
                // Spring Security 通常会自动加 ROLE_，根据你的实际存值调整
                .collect(Collectors.toList());

        // 构建查询：办理人是我 OR 候选组包含我的角色
        TaskQuery query = taskService.createTaskQuery()
                .or()
                    .taskAssignee(userId)
                    .taskCandidateGroupIn(groupIds)
                .endOr()
                .initializeFormKeys() // 如果需要表单Key
                .orderByTaskCreateTime().desc();

        // 执行分页查询
        long total = query.count();
        List<Task> taskList = query.listPage((pageNum - 1) * pageSize, pageSize);

        // 转换为 DTO

        List<TaskDto> dtos = new ArrayList<>();
        for (Task task : taskList) {
            dtos.add(toTaskDto(task));
        }
        IPage<TaskDto> page = new Page<>(pageNum, pageSize);
        page.setTotal(total);
        page.setRecords(dtos);
        return page;
    }

    /**
     * 获取单个任务详情
     */
    public TaskDto getTaskInfo(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            throw new BizException(CommonStateCode.DATA_NOT_EXISTS);
        }
        return toTaskDto(task);
    }

    /**
     * 将 Camunda Task 转换为自定义 TaskDto 并填充丰富信息
     */
    private TaskDto toTaskDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setTaskId(task.getId());
        dto.setTaskName(task.getName());
        dto.setAssignee(task.getAssignee());
        dto.setCreateTime(task.getCreateTime());
        dto.setProcessInstanceId(task.getProcessInstanceId());
        dto.setProcessDefinitionId(task.getProcessDefinitionId());

        // 1. 查询流程实例 (获取 BusinessKey)
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(task.getProcessInstanceId())
                .singleResult();
        if (processInstance != null) {
            dto.setBusinessKey(processInstance.getBusinessKey());
        }

        // 2. 查询流程定义 (获取流程名称和Key)
        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
                .processDefinitionId(task.getProcessDefinitionId())
                .singleResult();
        if (pd != null) {
            dto.setProcessName(pd.getName());
            dto.setProcessCode(pd.getKey());
        }

        // 3. 查询历史流程实例 (获取发起人 ID)
        HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery()
                .processInstanceId(task.getProcessInstanceId())
                .singleResult();

        if (historicProcessInstance != null && historicProcessInstance.getStartUserId() != null) {
            String initiatorId = historicProcessInstance.getStartUserId();
            dto.setUserName(initiatorId);
            // 4. 查询用户表 (获取发起人昵称)
            // 注意：生产环境建议使用缓存，避免循环查库
            UserEntity userEntity = userRepo.getByUsername(initiatorId);
            if (userEntity != null) {
                dto.setNickName(userEntity.getNickname());
            } else {
                dto.setNickName(initiatorId);
            }
        }

        return dto;
    }

    /**
     * 3. 完成任务 (审批)
     */
    @Transactional(rollbackFor = Exception.class)
    public void completeTask(String taskId, Map<String, Object> variables) {
        // 检查任务是否存在
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            throw new RuntimeException("任务不存在或已被处理");
        }
        
        // 可以在这里校验当前用户是否有权处理该任务
        // String currentUserId = SecurityUtil.getCurrentUsername();
        // if (task.getAssignee() != null && !task.getAssignee().equals(currentUserId)) { ... }

        // 完成任务，并传入变量（如 approveStatus=true/false, comment=...）
        taskService.complete(taskId, variables);
    }
    
    /**
     * 4. 签收任务 (用于组任务，先签收再办理，避免多人撞车)
     */
    public void claimTask(String taskId) {
        String userId = SecurityUtil.getCurrentUsername();
        taskService.claim(taskId, userId);
    }
}