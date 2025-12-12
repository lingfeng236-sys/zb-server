package com.lingfeng.camundastudy.controller.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello! 你已成功访问受保护的资源！";
    }

    // 获取当前登录用户信息的接口
    @GetMapping("/me")
    public String me() {
        // 核心知识点：从 SecurityContextHolder 获取当前用户信息
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "当前登录用户: " + auth.getName() + ", 权限: " + auth.getAuthorities();
    }
}