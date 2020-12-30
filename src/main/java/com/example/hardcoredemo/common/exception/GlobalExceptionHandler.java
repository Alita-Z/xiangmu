package com.example.hardcoredemo.common.exception;

import com.example.hardcoredemo.common.entity.Result;
import com.example.hardcoredemo.common.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理类
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result exceptionHandler_MethodArgumentNotValidException(HttpServletRequest request, Exception methodArgumentNotValidException){
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        log.error("【进入 参数异常 请求路径URI：{} 请求contextPath：{}】", requestURI, contextPath);
        methodArgumentNotValidException.printStackTrace();
        return Result.fail(ResultCode.METHOD_ARGUMENT_NOT_VALID);
    }

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(HttpServletRequest request, Exception e){
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        e.printStackTrace();
        //绑定异常是需要明确提示给用户的
//        if(e instanceof UnauthorizedException){
//            UnauthorizedException exception=(UnauthorizedException) e;
//            String msg = exception.getMessage();
//            log.error("【进入 shiro UnauthorizedException 异常 请求路径URI： {}  请求contextPath：{} {}】", requestURI, contextPath);
//            if (StringUtils.isNotEmpty(msg) && msg.startsWith("Subject does not have")){
//                return Result.fail(ResultCode.NOT_PERMISSION);
//            }
//            return Result.fail(ResultCode.NOT_LOGIN);
//        }
        //事物回滚异常
        if(e instanceof BaseException){
            BaseException exception=(BaseException) e;
            log.error("【进入 BaseException 请求路径URI：{}  请求contextPath：{} 异常信息 {}】", requestURI, contextPath, exception.getResultCode().msg);
            return Result.fail(exception.getResultCode());
        }
        // 异常简单返回为系统异常
        log.error("【进入 未知异常 请求路径URI：{} 请求contextPath：{} 异常信息 {}】", requestURI, contextPath, e.getMessage());
        return Result.fail(ResultCode.ERROR);
    }

//    @ExceptionHandler(AuthorizationException.class)
//    public Result handleAuthorizationException(AuthorizationException e){
//        log.error(e.getMessage(), e);
//        return Result.fail(ResultCode.NOT_PERMISSION);
//    }
}
