package com.lingfeng.camundastudy.enums.user;

import com.lingfeng.camundastudy.enums.base.BaseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderEnum implements BaseCodeEnum {
    MALE(1, "男"),
    FEMALE(2, "女");

    private final Integer code;
    private final String text;

    @Override
    public Integer getCode() {
        return this.code;
    }
}
