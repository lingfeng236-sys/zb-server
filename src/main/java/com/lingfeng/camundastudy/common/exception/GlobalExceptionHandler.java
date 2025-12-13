package com.lingfeng.camundastudy.common.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.lingfeng.camundastudy.common.constant.CommonStateCode;
import com.lingfeng.camundastudy.common.domain.Result;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result<String> handleBindException(MethodArgumentNotValidException exception) {
        log.warn("handleBindException warn:", exception);
        final BindingResult result = exception.getBindingResult();
        final List<FieldError> allErrors = result.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError errorMessage : allErrors) {
            sb.append(errorMessage.getField()).append(": ").append(errorMessage.getDefaultMessage()).append(", ");
        }
        return Result.newFailedResult(CommonStateCode.ILLEGAL_PARAMETER, sb.toString());
    }

    @ExceptionHandler(InvalidFormatException.class)
    public Result<String> handleInvalidFormatException(InvalidFormatException exception) {
        log.warn("handleInvalidFormatException warn:", exception);
        return Result.newFailedResult(CommonStateCode.ILLEGAL_PARAMETER, exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Result<String> handleConstraintViolationException(ConstraintViolationException exception) {
        log.warn("handleConstraintViolationException warn:", exception);
        return Result.newFailedResult(CommonStateCode.ILLEGAL_PARAMETER, exception.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result<String> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException exception) {
        log.warn("handleHttpMediaTypeNotSupportedException warn:", exception);
        return Result.newFailedResult(CommonStateCode.ILLEGAL_PARAMETER, exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Result<String> handleIllegalArgumentException(IllegalArgumentException exception) {
        log.warn("handleIllegalArgumentException warn:", exception);
        return Result.newFailedResult(CommonStateCode.ILLEGAL_PARAMETER, exception.getMessage());
    }

    @ExceptionHandler(BizException.class)
    public Result<String> handleBizException(BizException exception) {
        log.warn("biz exception", exception);
        return Result.newFailedResult(exception.getErrCode(), exception.getMessage());
    }

    /**
     * 处理 Spring Security 认证异常 (401)
     * 注意：方法级权限校验抛出的异常会被这里捕获
     */
    @ExceptionHandler(AuthenticationException.class)
    public Result<String> handleAuthenticationException(AuthenticationException exception) {
        log.warn("认证失败", exception);
        return Result.forbidden(null);
    }

    /**
     * 处理 Spring Security 6.x 授权异常 (403)
     * Spring Security 6.x 使用 AuthorizationDeniedException 替代了 AccessDeniedException
     */
    @ExceptionHandler(AuthorizationDeniedException.class)
    public Result<String> handleAuthorizationDeniedException(AuthorizationDeniedException exception) {
        log.warn("权限不足: {}", exception.getMessage());
        return Result.forbidden(null);
    }

    /**
     * 处理 Spring Security 旧版授权异常 (403)
     * 兼容处理，以防某些地方还在使用旧的异常类型
     */
    @ExceptionHandler(AccessDeniedException.class)
    public Result<String> handleAccessDeniedException(AccessDeniedException exception) {
        log.warn("权限不足: {}", exception.getMessage());
        return Result.forbidden(null);
    }

    /**
     * 异常处理，不应该把堆栈信息直接返回给前端，只需要记录错误日志方便排查
     * @return Result<String>
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        log.error("系统异常", e);
        return Result.newFailedResult(e.getMessage());
    }
}
