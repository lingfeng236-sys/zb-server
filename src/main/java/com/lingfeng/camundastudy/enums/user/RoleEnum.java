package com.lingfeng.camundastudy.enums.user;

import com.lingfeng.camundastudy.common.constant.RoleConst;
import com.lingfeng.camundastudy.enums.base.BaseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum implements BaseCodeEnum {

    ADMIN(1, RoleConst.ADMIN),
    USER(2, RoleConst.USER),
    ;
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
