package com.lingfeng.camundastudy.common.security.filter;

import com.lingfeng.camundastudy.common.constant.StringConstant;
import com.lingfeng.camundastudy.common.util.JwtUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final String headerString = StringConstant.AUTHORIZATION;
    private static final String tokenPrefix = StringConstant.TOKEN_PREFIX;

    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private UserDetailsService userDetailsService; // 也就是你在第二阶段写的那个 Service

    @Resource
    private IdentityService identityService; // 注入 Camunda 身份服务

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 1. 获取请求头中的 Authorization
        String authHeader = request.getHeader(headerString);

        // 2. 检查 Header 格式：必须以 "Bearer " 开头
        if (authHeader == null || !authHeader.startsWith(tokenPrefix)) {
            // 如果没有 Token，直接放行（交给后面的过滤器去处理，它们会发现没登录并拒绝）
            filterChain.doFilter(request, response);
            return;
        }

        // 3. 提取 Token
        String token = authHeader.substring(tokenPrefix.length()); // 去掉 "Bearer "

        // 4. 验证 Token
        String username = null;
        try {
            if (jwtUtil.validateToken(token)) {
                username = jwtUtil.extractUsername(token);
            }
        } catch (Exception e) {
            // Token 无效，这里可以记录日志
            log.error("Token 无效：", e);
        }

        // 5. 如果 Token 有效，且当前上下文没有认证信息（防止重复认证）
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // 加载用户详情（为了获取权限/角色）
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // 创建认证令牌
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            // ⚠️ 关键步骤：将认证信息存入 SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 2. 【核心修改】告诉 Camunda 当前登录人是谁
            try {
                identityService.setAuthenticatedUserId(username);
                // 继续执行过滤器链
                filterChain.doFilter(request, response);
            } finally {
                // 3. 【务必清理】请求结束后清理线程变量，防止线程复用导致身份混淆
                identityService.clearAuthentication();
            }
            return; // 这一步 return 很重要，避免下面重复调用 doFilter
        }

        // 6. 继续执行过滤器链
        filterChain.doFilter(request, response);
    }
}