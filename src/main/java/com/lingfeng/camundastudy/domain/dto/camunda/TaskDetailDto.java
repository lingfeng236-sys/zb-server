package com.lingfeng.camundastudy.domain.dto.camunda;

import lombok.Data;

@Data
public class TaskDetailDto<T> {
    /**
     * 流程任务信息 (节点名称、办理人、时间等)
     */
    private TaskDto taskInfo;

    /**
     * 关联的业务单据数据 (请假单、报销单等)
     * 前端根据 taskInfo.processDefinitionKey 来决定如何渲染这个对象
     */
    private T businessData;
}