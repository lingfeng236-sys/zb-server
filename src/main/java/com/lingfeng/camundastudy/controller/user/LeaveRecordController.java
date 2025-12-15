package com.lingfeng.camundastudy.controller.user;

import com.lingfeng.camundastudy.common.domain.Result;
import com.lingfeng.camundastudy.domain.dto.camunda.TaskDetailDto;
import com.lingfeng.camundastudy.domain.dto.camunda.TaskDto;
import com.lingfeng.camundastudy.domain.dto.user.LeaveRecordDto;
import com.lingfeng.camundastudy.service.user.LeaveRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leave")
@Tag(name = "人员请假", description = "人员请假")
public class LeaveRecordController {

    @Resource
    private LeaveRecordService leaveRecordService;
    /**
     * 聚合详情接口：获取任务详情 + 业务详情
     * 前端点“审批”时调用此接口，回显数据
     */
    @GetMapping("/task/detail/{taskId}")
    @Operation(summary = "获取任务及业务详情")
    public Result<TaskDetailDto<LeaveRecordDto>> getTaskDetail(@PathVariable String taskId) {

        TaskDetailDto<LeaveRecordDto> result = leaveRecordService.getTaskDetail(taskId);
        return Result.ok(result);
    }
}
