package com.lingfeng.camundastudy.controller.security;

import com.lingfeng.camundastudy.common.annotation.security.IsAdmin;
import com.lingfeng.camundastudy.common.annotation.security.IsUser;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Tag(name = "订单管理", description = "订单管理接口")
public class OrderController {

    // 只有拥有 "ADMIN" 角色的用户能删订单
    @IsAdmin
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return "订单 " + id + " 已删除";
    }

    @IsUser
    @GetMapping("/{id}")
    public String getOrder(@PathVariable Long id) {
        return "订单详情...";
    }
    
    // 甚至可以使用 SpEL 表达式调用 Bean 方法检查更复杂的逻辑
    // @PreAuthorize("@mySecurityService.hasPermission(#id)")
}