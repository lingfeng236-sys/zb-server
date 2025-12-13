package com.lingfeng.camundastudy.common.annotation.security;

import com.lingfeng.camundastudy.common.constant.RoleConst;
import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
// SpEL 解析：
// 1. hasRole('ADMIN') -> 管理员直接过
// 2. #username == authentication.name -> 参数里的 username 等于当前登录用户名
@PreAuthorize("hasRole('" + RoleConst.ADMIN + "') or #username == authentication.name")
public @interface IsOwnerOrAdmin {
}