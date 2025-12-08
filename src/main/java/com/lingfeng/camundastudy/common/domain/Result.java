package com.lingfeng.camundastudy.common.domain;

import com.lingfeng.camundastudy.common.constant.CommonStateCode;
import lombok.Data;

/**
 * comment:
 * author: zhuozhijin
 * date: 2022/1/4 11:18 AM
 */
@Data
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    public Result() {
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> newFailedResult(String msg) {
        return new Result<>(CommonStateCode.ERROR.getCode(), msg, null);
    }

    public static <T> Result<T> newFailedResult(Integer code, String msg) {
        return new Result<>(code, msg, null);
    }

    public static <T> Result<T> newFailedResult(CommonStateCode stateCode) {
        return new Result<>(stateCode.getCode(), stateCode.getMsg(), null);
    }

    public static Result<String> newFailedResult(CommonStateCode stateCode, String msg) {
        return new Result<>(stateCode.getCode(), stateCode.getMsg(), msg);
    }

    public static <T> Result<T> newImport(CommonStateCode stateCode, String msg) {
        return new Result<>(stateCode.getCode(), msg, null);
    }

    public static <T> Result<T> newImport(CommonStateCode stateCode, String msg, T data) {
        return new Result<>(stateCode.getCode(), msg, data);
    }

    public static <T> Result<T> newSuccessResult(T data) {
        return new Result<>(CommonStateCode.SUCCESS.getCode(), CommonStateCode.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> ok() {
        return new Result<>(CommonStateCode.SUCCESS.getCode(), CommonStateCode.SUCCESS.getMsg(), null);
    }


    public static <T> Result<T> ok(T data) {
        return new Result<>(CommonStateCode.SUCCESS.getCode(), CommonStateCode.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> ok(String info, T data) {
        return new Result<>(CommonStateCode.SUCCESS.getCode(), info, data);
    }

    /**
     * 未登录返回结果
     */
    public static <T> Result<T> unauthorized(T data) {
        return new Result<T>(CommonStateCode.UNAUTHORIZED.getCode(), CommonStateCode.UNAUTHORIZED.getMsg(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> Result<T> forbidden(T data) {
        return new Result<T>(CommonStateCode.FORBIDDEN.getCode(), CommonStateCode.FORBIDDEN.getMsg(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(CommonStateCode.SUCCESS.getCode(), CommonStateCode.SUCCESS.getMsg(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> Result<T> success(T data, String message) {
        return new Result<T>(CommonStateCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> Result<T> failed(CommonStateCode errorCode) {
        return new Result<T>(errorCode.getCode(), errorCode.getMsg(), null);
    }

    public static <T> Result<T> failed(T data) {
        return new Result<>(CommonStateCode.ERROR.getCode(), CommonStateCode.ERROR.getMsg(), data);
    }

    public static <T> Result<T> failed(CommonStateCode errorCode, T data) {
        return new Result<>(errorCode.getCode(), errorCode.getMsg(), data);
    }
    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static <T> Result<T> failed(CommonStateCode errorCode, String message) {
        return new Result<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> Result<T> failed(String message) {
        return new Result<T>(CommonStateCode.ERROR.getCode(), message, null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> Result<T> failed(String message, T data) {
        return new Result<T>(CommonStateCode.ERROR.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> Result<T> failed(T data, CommonStateCode errorCode, String message) {
        return new Result<T>(errorCode.getCode(), message, data);
    }

    /**
     *  失败返回结果
     */
    public static <T> Result<T> failed(T data, CommonStateCode errorCode) {
        return new Result<T>(errorCode.getCode(), errorCode.getMsg(), data);
    }


    /**
     * 失败返回结果
     */
    public static <T> Result<T> failed() {
        return failed(CommonStateCode.ERROR);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> Result<T> validateFailed() {
        return failed(CommonStateCode.ILLEGAL_PARAMETER);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> Result<T> validateFailed(String message) {
        return new Result<T>(CommonStateCode.ILLEGAL_PARAMETER.getCode(), message, null);
    }

}

