package com.lingfeng.camundastudy.controller;

import com.lingfeng.camundastudy.common.domain.Result;
import com.lingfeng.camundastudy.service.ProcessService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/process")
@Tag(name = "流程", description = "流程的生命周期") // 控制器标签
public class ProcessController {

    @Resource
    private ProcessService processService;
    // 部署
    @GetMapping("/deploy")
    @Operation(summary = "部署")
    public Result<String> deploy(@RequestParam String processCode) {
        return Result.ok(processService.deploy(processCode));
    }

}
