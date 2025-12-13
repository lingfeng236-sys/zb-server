package com.lingfeng.camundastudy.common.annotation.security;

import com.lingfeng.camundastudy.common.constant.RoleConst;
import org.springframework.security.access.prepost.PreAuthorize;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@PreAuthorize("hasRole('" + RoleConst.USER + "')")
public @interface IsUser {
}