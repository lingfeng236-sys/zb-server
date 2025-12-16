package com.lingfeng.camundastudy.domain.dto.camunda;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class ProcessDiagramDto {
    // BPMN XML 字符串
    private String xml;
    // 当前正在进行的节点 ID 列表（用于高亮）
    private List<String> activeActivityIds;
    // 已经走过的节点 ID 列表（可选，用于展示历史轨迹）
    private List<String> finishedActivityIds;
}