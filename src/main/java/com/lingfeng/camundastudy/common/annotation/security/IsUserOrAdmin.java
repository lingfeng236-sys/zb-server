package com.lingfeng.camundastudy.common.annotation.security;

import com.lingfeng.camundastudy.common.constant.RoleConst;
import org.springframework.security.access.prepost.PreAuthorize;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
// 使用 hasAnyRole
@PreAuthorize("hasAnyRole('" + RoleConst.USER + "', '" + RoleConst.ADMIN + "')")
public @interface IsUserOrAdmin {
}