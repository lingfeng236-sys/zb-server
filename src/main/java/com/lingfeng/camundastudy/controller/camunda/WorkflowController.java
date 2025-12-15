package com.lingfeng.camundastudy.controller.camunda;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lingfeng.camundastudy.common.domain.Result;
import com.lingfeng.camundastudy.domain.dto.camunda.TaskDto;
import com.lingfeng.camundastudy.service.camunda.WorkflowService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/workflow")
@Tag(name = "工作流中心", description = "统一流程服务接口")
public class WorkflowController {

    @Resource
    private WorkflowService workflowService;

    @GetMapping("/tasks/todo")
    @Operation(summary = "获取我的待办任务")
    public Result<IPage<TaskDto>> getMyTodoTasks(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.ok(workflowService.getTodoTasks(pageNum, pageSize));
    }

    @PostMapping("/task/complete/{taskId}")
    @Operation(summary = "完成/审批任务")
    public Result<Void> completeTask(@PathVariable String taskId, @RequestBody Map<String, Object> variables) {
        // variables 示例: { "approved": true, "comment": "同意" }
        workflowService.completeTask(taskId, variables);
        return Result.ok();
    }
    
    @PostMapping("/task/claim/{taskId}")
    @Operation(summary = "签收任务")
    public Result<Void> claimTask(@PathVariable String taskId) {
        workflowService.claimTask(taskId);
        return Result.ok();
    }
}