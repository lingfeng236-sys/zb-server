package com.lingfeng.camundastudy.common.security.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingfeng.camundastudy.common.domain.Result;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class SecurityExceptionHandler implements AuthenticationEntryPoint, AccessDeniedHandler {

    @Resource
    private ObjectMapper objectMapper;

    // 处理 401 (未登录/Token失效)
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(401);
        Result<String> result = Result.unauthorized(null);
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }

    // 处理 403 (无权限) - Filter 层异常-代码未生效，可以用别的途径实现
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(403);
        Result<String> result = Result.forbidden(null);
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}