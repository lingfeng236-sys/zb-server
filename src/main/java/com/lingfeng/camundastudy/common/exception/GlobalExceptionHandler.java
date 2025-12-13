package com.lingfeng.camundastudy.common.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.lingfeng.camundastudy.common.constant.CommonStateCode;
import com.lingfeng.camundastudy.common.domain.Result;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
     * 异常处理，不应该把堆栈信息直接返回给前端，只需要记录错误日志方便排查
     * @return Result<String>
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        log.error("系统异常", e);
        return Result.newFailedResult(CommonStateCode.ERROR, e.getMessage());
    }
}
