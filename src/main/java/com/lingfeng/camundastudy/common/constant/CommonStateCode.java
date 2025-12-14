package com.lingfeng.camundastudy.common.constant;

import lombok.Getter;

/**
 * comment:
 * author: zhuozhijin
 * date: 2022/1/5 3:37 PM
 */
@Getter
public enum CommonStateCode {
    //系统相关功能 3000-4500
    SUCCESS(200, "成功", "Success"),

    UNAUTHORIZED(401, "未登录或登录信息已过期,请重新登录","Not logged in or login expired, please try log in again"),
    FORBIDDEN(403, "没有权限","No permission"),
    ERROR(500, "服务端错误","Server error"),
    LACK_SETTING(501,"服务端错误(缺少基本配置)","Server error (missing basic configuration)"),
    EXIST_ILLEGAL_DATA(502,"服务端存在非法数据","Server error (exist illegal data)"),
    ACQUIRE_SYSTEM_RESOURCE_FAIL(503,"服务端错误(获取系统资源失败)","Server error (acquire system resource failed)"),
    THERE_ARE_MANDATORY_FIELDS_THAT_HAVE_NOT_BEEN_FILLED_IN(1001,"存在必填字段未填","Mandatory fields are missing"),
    VALUE_NOT_NULL(1002,"值[#{param}]不能为空","Value [#{param}] can not null"),
    VALUE_ALREADY_EXISTS(1003,"值[#{param}]已存在","Value [#{param}] already exists"),
    VALUE_NOT_EXISTS(1004,"值[#{param}]不存在","Value [#{param}] not exists"),
    DATA_ALREADY_EXISTS(3001,"数据已存在","Data already exists"),
    BUSINESS_CODE_IS_NOT_EXIST(3002,"businessCode不存在","Original item code does not exist"),
    DATA_NOT_EXISTS(3003,"数据不存在","Data does not exist"),
    DATA_FORBIDDEN(4000, "没有数据权限","No Data Permission"),
    ILLEGAL_PARAMETER(4001, "非法参数","Illegal parameter"),
    LACK_PARAMETER(4002,"缺少参数","Missing parameter"),
    URL_TRANSFORMATION_FAILED(4003,"url转换失败，格式错误","url transformation failed, format error"),
    BUSINESS_TASK_DATA_IS_EMPTY(4004,"任务数据为空","Task data is empty"),
    LACK_LOCK_KEY_PARAMETER(4005,"缺少关键锁参数","Missing Lock Key Parameter"),
    ERROR_PARAM(500, "服务端错误:[#{param}]","Server error"),

    // 用户相关功能 4500-5000
    USER_NOT_EXIST(4500, "用户不存在"),
    USER_NOT_LOGIN(4501, "用户未登录"),
    USER_NOT_LOGOUT(4502, "用户未登出"),
    USER_PASSWORD_ERROR(4503, "旧密码错误"),
    USER_ALREADY_EXIST(4504, "用户已存在")
    ;

    private final Integer code;
    private final String msg;
    private String enMsg;

    CommonStateCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    CommonStateCode(Integer code, String msg, String enMsg) {
        this.code = code;
        this.msg = msg;
        this.enMsg = enMsg;
    }

    @Override
    public String toString() {
        return "{\"code\":\"" + code + "\",\"msg\":\"" + msg + "\"}";
    }
}
