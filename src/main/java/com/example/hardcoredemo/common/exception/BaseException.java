package com.example.hardcoredemo.common.exception;


import com.example.hardcoredemo.common.enums.ResultCode;

public class BaseException extends RuntimeException {
    private int code;
    private String message;
    private ResultCode resultCode;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
        this.message = message;
    }

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(ResultCode resultCode) {
        super(resultCode.msg);
        this.message = resultCode.msg;
        this.code = resultCode.code;
        this.resultCode = resultCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
