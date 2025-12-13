package com.lingfeng.camundastudy.controller.security;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "安全接口", description = "安全接口")
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


    // 1. 公开接口
    @GetMapping("/public/info")
    public String publicInfo() {
        return "这是公开信息，大家都能看";
    }

    // 2. 普通接口（需要登录）
    @GetMapping("/home")
    public String home() {
        return "欢迎来到主页（只要登录就能看）";
    }

    // 3. 管理员接口
    @GetMapping("/admin/data")
    public String adminData() {
        return "这是管理员机密数据！";
    }
}