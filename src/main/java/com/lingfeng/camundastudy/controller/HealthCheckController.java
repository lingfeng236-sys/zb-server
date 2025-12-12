package com.lingfeng.camundastudy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/actuator")
@Tag(name = "健康检查", description = "健康检查") // 控制器标签
public class HealthCheckController {

    @Operation(summary = "健康检查")
    @GetMapping("/health")
    public String health() {
        return "{\"status\":\"UP\"}";
    }

}