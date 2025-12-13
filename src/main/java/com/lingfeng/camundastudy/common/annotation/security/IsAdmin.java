package com.lingfeng.camundastudy.common.annotation.security;

import com.lingfeng.camundastudy.common.constant.RoleConst;
import org.springframework.security.access.prepost.PreAuthorize;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE}) // 既可以用在方法上，也可以用在类上
@Retention(RetentionPolicy.RUNTIME)           // 运行时有效
@Documented
// 👇 核心：这里引用常量，如果以后 ADMIN 变成了 ROOT，只改常量类即可
@PreAuthorize("hasRole('" + RoleConst.ADMIN + "')")
public @interface IsAdmin {
}