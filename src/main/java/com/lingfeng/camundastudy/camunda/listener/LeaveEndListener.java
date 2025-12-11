package com.lingfeng.camundastudy.camunda.listener;

import com.lingfeng.camundastudy.dao.repo.LeaveRecordRepo;
import com.lingfeng.camundastudy.domain.entity.LeaveRecordEntity;
import com.lingfeng.camundastudy.enums.ApprovalStatus;
import jakarta.annotation.Resource;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

@Component("leaveEndListener")
public class LeaveEndListener implements ExecutionListener {
    
    @Resource
    private LeaveRecordRepo leaveRecordRepo;

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        // 1. 获取启动时传进来的 BusinessKey (也就是 1001)
        String businessKey = execution.getProcessBusinessKey();
        
        Long recordId = Long.parseLong(businessKey);
        
        // 2. 更新你的业务表
        LeaveRecordEntity record = new LeaveRecordEntity();
        record.setId(recordId);
        record.setStatus(ApprovalStatus.APPROVED);
        leaveRecordRepo.updateById(record);
    }
}