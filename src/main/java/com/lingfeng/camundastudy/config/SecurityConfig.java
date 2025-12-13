package com.lingfeng.camundastudy.config;

import com.lingfeng.camundastudy.common.security.filter.JwtAuthenticationFilter;
import com.lingfeng.camundastudy.common.security.handle.SecurityExceptionHandler;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity // 开启 Spring Security 的自定义配置
@EnableMethodSecurity // <--- 开启注解权限控制
public class SecurityConfig {

    @Resource
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Resource
    private SecurityExceptionHandler securityExceptionHandler;

    // 1. 密码加密器：使用 BCrypt（这是行业标准）
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. 配置拦截规则（SecurityFilterChain）
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1. 关闭 CSRF (前后端分离通常不需要，且会阻碍 POST 请求)
                .csrf(AbstractHttpConfigurer::disable)
                // 2. 启用 CORS
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                // 3. 设置 Session 管理策略为无状态 (STATELESS)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 4. 授权规则
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()     // 所有人都可以访问以 /public 开头的接口
                        .requestMatchers("/admin/**").hasRole("ADMIN") // 只有拥有 ADMIN 角色的用户可以访问 /admin
                        .requestMatchers("/user/login", "/user/register").permitAll() // ⚠️ 放行登录接口，否则谁也进不来
                        .requestMatchers("/enum/**").permitAll() // 允许未登录访问枚举接口
                        .anyRequest().authenticated()                  // 其他所有接口都需要登录才能访问
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                // 🔥 新增：配置异常处理
                .exceptionHandling(exceptions -> exceptions
                        .authenticationEntryPoint(securityExceptionHandler) // 处理 401
                        .accessDeniedHandler(securityExceptionHandler)      // 处理 403
                )
                ;

        return http.build();
    }

    // 还需要暴露 AuthenticationManager，用于我们在登录接口中手动调用认证
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // 配置 CORS
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // 允许的源（前端地址），生产环境应指定具体域名
        configuration.setAllowedOriginPatterns(List.of("*")); // 允许所有来源，也可以指定具体的前端地址如 "http://localhost:3000"
        // 允许的 HTTP 方法
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        // 允许的请求头
        configuration.setAllowedHeaders(List.of("*"));
        // 是否允许携带凭证（如 Cookie）
        configuration.setAllowCredentials(true);
        // 预检请求的有效期（秒）
        configuration.setMaxAge(3600L);
        // 暴露的响应头
        configuration.setExposedHeaders(Arrays.asList("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // 对所有路径生效
        return source;
    }
}