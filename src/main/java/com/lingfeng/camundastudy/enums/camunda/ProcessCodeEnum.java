package com.lingfeng.camundastudy.enums.camunda;

import com.lingfeng.camundastudy.enums.base.BaseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProcessCodeEnum implements BaseCodeEnum<String> {
    PROCESS_LEAVE("process_leave", "智能请假流程"),
    ;

    private final String code;
    private final String desc;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

}
