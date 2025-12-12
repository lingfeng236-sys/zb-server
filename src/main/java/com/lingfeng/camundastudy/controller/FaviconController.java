package com.lingfeng.camundastudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Favicon控制器，用于处理根路径下的favicon.ico请求
 * 替代已过时的spring.mvc.favicon.enabled=false配置
 */
@RestController
public class FaviconController {

    /**
     * 处理favicon请求，返回空响应以禁用favicon，避免404错误
     */
    @GetMapping("favicon.ico")
    @ResponseBody
    public void favicon() {
        // 返回空响应以禁用favicon，避免404错误
    }
}