package com.example.hardcoredemo.common.entity;


import com.example.hardcoredemo.common.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * http result
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    private Result(ResultCode resultCode, T data) {
        this.code = resultCode.code;
        this.msg = resultCode.msg;
        this.data = data;
    }

    private Result(String msg, Integer code) {
        this.code = code;
        this.msg = msg;
    }

    public static Result<Map<String, Object>> success() {
        return new Result<>(ResultCode.SUCCESS, null);
    }

    public static <T> Result<T> success(T respData) {
        return new Result<>(ResultCode.SUCCESS, respData);
    }

    public static <T> Result<T> fail(ResultCode resultCode, T respData) {
        return new Result<>(resultCode, respData);
    }

    public static <T> Result<T> fail(String msg, Integer code) {
        return new Result(msg, code);
    }

    public static Result<Map<String, Object>> fail(ResultCode resultCode) {
        return new Result<>(resultCode, null);
    }

    public Result<T> initData(T data) {
        this.data = data;
        return this;
    }
}
