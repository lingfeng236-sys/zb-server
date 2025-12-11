package com.lingfeng.camundastudy.enums;

import com.lingfeng.camundastudy.enums.base.BaseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApprovalStatus implements BaseCodeEnum {
    // 审批中
    PENDING(0, "审批中"),
    // 通过
    APPROVED(1, "通过"),
    // 拒绝
    REJECTED(2, "拒绝"),
    ;

    private final Integer code;
    private final String desc;
    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
