package com.lingfeng.camundastudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 开启 Spring Security 的自定义配置
public class SecurityConfig {

    // 1. 密码加密器：使用 BCrypt（这是行业标准）
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. 配置用户（UserDetailsService）：为了演示，我们将用户存在内存中
    // 在真实项目中，这里会替换为从数据库读取
    @Bean
    public UserDetailsService userDetailsService() {
        // 创建一个普通用户: user / 123456
        UserDetails normalUser = User.builder()
                .username("user")
                .password(passwordEncoder().encode("123456")) // 必须加密
                .roles("USER") // 角色
                .build();

        // 创建一个管理员: admin / 123456
        UserDetails adminUser = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("123456"))
                .roles("ADMIN") // 管理员角色
                .build();

        // 将这两个用户放入内存管理器
        return new InMemoryUserDetailsManager(normalUser, adminUser);
    }

    // 3. 配置拦截规则（SecurityFilterChain）
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 配置请求授权规则
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll()     // 所有人都可以访问以 /public 开头的接口
                .requestMatchers("/admin/**").hasRole("ADMIN") // 只有拥有 ADMIN 角色的用户可以访问 /admin
                .anyRequest().authenticated()                  // 其他所有接口都需要登录才能访问
            )
            // 开启表单登录（也就是那个默认的登录页面）
            .formLogin(form -> form
                .loginPage("/login")    // 如果你想用自己的登录页面，可以在这里配置（暂时不用）
                .permitAll()            // 登录页面本身必须所有人都能访问
            );

        return http.build();
    }
}