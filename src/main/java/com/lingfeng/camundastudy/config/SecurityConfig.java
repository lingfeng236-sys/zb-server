package com.lingfeng.camundastudy.config;

import com.lingfeng.camundastudy.common.security.filter.JwtAuthenticationFilter;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // 开启 Spring Security 的自定义配置
public class SecurityConfig {

    @Resource
    private JwtAuthenticationFilter jwtAuthenticationFilter;

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
                // 2. 设置 Session 管理策略为无状态 (STATELESS)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 3. 授权规则
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()     // 所有人都可以访问以 /public 开头的接口
                        .requestMatchers("/admin/**").hasRole("ADMIN") // 只有拥有 ADMIN 角色的用户可以访问 /admin
                        .requestMatchers("/user/login").permitAll() // ⚠️ 放行登录接口，否则谁也进不来
                        .anyRequest().authenticated()                  // 其他所有接口都需要登录才能访问
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                ;

        return http.build();
    }

    // 还需要暴露 AuthenticationManager，用于我们在登录接口中手动调用认证
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}