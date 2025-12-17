package com.lingfeng.camundastudy.service.camunda;

import com.lingfeng.camundastudy.common.util.SecurityUtil;
import com.lingfeng.camundastudy.dao.repo.LeaveRecordRepo;
import com.lingfeng.camundastudy.domain.entity.LeaveRecordEntity;
import com.lingfeng.camundastudy.enums.ApprovalStatus;
import com.lingfeng.camundastudy.enums.camunda.ProcessCodeEnum;
import jakarta.annotation.Resource;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.history.HistoricVariableInstance;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CamundaTestService {

    @Resource
    private HistoryService historyService;

    @Resource
    private LeaveRecordRepo leaveRecordRepo;

    @Resource
    private WorkflowService workflowService;

    public void searchHistory() {
        // 查询所有已经结束的、变量 applicant = "Bob" 的流程
        List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery()
                .finished() // 只查结束的
                .variableValueEquals("applicant", "Bob")
                .list();

        // 或者直接查历史变量细节
        List<HistoricVariableInstance> vars = historyService.createHistoricVariableInstanceQuery()
                .variableName("day")
                .list();

        for (HistoricVariableInstance var : vars) {
            System.out.println("变量值: " + var.getValue() + ", 所属流程实例: " + var.getProcessInstanceId());
        }
    }


    public void startLeave(String name, Integer day) {
        // 1. 【先】保存业务数据到自己的表
        LeaveRecordEntity leaveRecordEntity = new LeaveRecordEntity();
        leaveRecordEntity.setApplicant(name);
        leaveRecordEntity.setDays(day);
        leaveRecordEntity.setStatus(ApprovalStatus.PENDING); // 初始状态：审批中
        leaveRecordRepo.save(leaveRecordEntity);

        // 获取业务主键 ID，例如：1001
        String businessKey = String.valueOf(leaveRecordEntity.getId());

        // 2. 【后】启动流程，并绑定 BusinessKey
        Map<String, Object> variables = new HashMap<>();
        variables.put("day", day); // 用于网关判断
        variables.put("approver", SecurityUtil.getCurrentUsername());
        workflowService.startProcess(ProcessCodeEnum.PROCESS_LEAVE.getCode(), businessKey, variables);

    }
}
