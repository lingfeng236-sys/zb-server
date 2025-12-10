package com.lingfeng.camundastudy.common.exception;


import com.lingfeng.camundastudy.common.constant.CommonStateCode;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 自定义业务异常
 */
@Getter
public class BizException extends RuntimeException {
    private final Integer errCode;
    private final String message;

    public BizException(CommonStateCode stateCode) {
        this.message = stateCode.getMsg();
        this.errCode = stateCode.getCode();
    }

}
