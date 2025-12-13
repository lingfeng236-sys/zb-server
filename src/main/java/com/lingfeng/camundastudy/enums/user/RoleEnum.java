package com.lingfeng.camundastudy.enums.user;

import com.lingfeng.camundastudy.enums.base.BaseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@AllArgsConstructor
public enum RoleEnum implements BaseCodeEnum {

    USER(1, "USER"),
    ADMIN(2, "ADMIN");
    private final Integer code;
    private final String role;


    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.role;
    }
}
