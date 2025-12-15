package com.lingfeng.camundastudy.domain.dto.camunda;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lingfeng.camundastudy.common.util.DateUtil;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class TaskDto {
    private String taskId;
    private String taskName;
    private String processInstanceId;
    private String processDefinitionId;
    
    // 业务关联键 (例如请假单ID)
    private String businessKey;
    
    // 任务办理人
    private String assignee;
    
    @JsonFormat(pattern = DateUtil.CT_DS, timezone = "GMT+8")
    private Date createTime;
    
    // 流程变量 (可选，用于前端展示额外信息)
    private Map<String, Object> variables;
}