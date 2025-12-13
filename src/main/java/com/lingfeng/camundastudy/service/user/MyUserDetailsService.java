package com.lingfeng.camundastudy.service.user;

import com.lingfeng.camundastudy.dao.repo.UserRepo;
import com.lingfeng.camundastudy.domain.entity.UserEntity;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("尝试加载用户: {}", username);
        // 1. 从数据库查询用户
        UserEntity sysUser = userRepo.findByUsername(username)
                .orElseThrow(() -> {
                    log.error("用户不存在: {}", username);
                    return new UsernameNotFoundException("用户不存在: " + username);
                });

        // 2. 将我们的 SysUser 转换为 Spring Security 的 UserDetails
        // 这里我们使用 Spring 提供的 User 构建器
        log.info("成功加载用户: {}, 角色: {}", sysUser.getUsername(), sysUser.getRole().getDesc());
        return User.builder()
                .username(sysUser.getUsername())
                .password(sysUser.getPassword()) // 数据库里的密码（必须是加密后的）
                .roles(sysUser.getRole().getDesc())        // 数据库里的角色
                .build();
    }
}