package com.lingfeng.camundastudy.service.user;

import com.lingfeng.camundastudy.common.util.StrUtils;
import com.lingfeng.camundastudy.convert.UserConvert;
import com.lingfeng.camundastudy.dao.repo.LeaveRecordRepo;
import com.lingfeng.camundastudy.domain.dto.camunda.TaskDetailDto;
import com.lingfeng.camundastudy.domain.dto.camunda.TaskDto;
import com.lingfeng.camundastudy.domain.dto.user.LeaveRecordDto;
import com.lingfeng.camundastudy.domain.entity.LeaveRecordEntity;
import com.lingfeng.camundastudy.enums.camunda.ProcessCodeEnum;
import com.lingfeng.camundastudy.service.camunda.WorkflowService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LeaveRecordService {

    @Resource
    private WorkflowService workflowService;

    @Resource
    private LeaveRecordRepo leaveRecordRepo;
    
    @Resource
    private UserConvert userConvert;


    public TaskDetailDto<LeaveRecordDto> getTaskDetail(String taskId) {

        TaskDto taskDto = workflowService.getTaskInfo(taskId);

        String businessKey = taskDto.getBusinessKey();
        LeaveRecordEntity leaveRecordEntity = leaveRecordRepo.getById(Long.parseLong(businessKey));
        LeaveRecordDto leaveRecordDto = userConvert.leaveRecordEntity2Dto(leaveRecordEntity);

        TaskDetailDto<LeaveRecordDto> taskDetailDto = new TaskDetailDto<>();
        taskDetailDto.setTaskInfo(taskDto);
        taskDetailDto.setBusinessData(leaveRecordDto);
        return taskDetailDto;
    }
}
