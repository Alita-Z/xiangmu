package com.example.hardcoredemo.modular.cognitive.common.enums;

public enum cognitiveEnum {
    WAIT_INSERT(10000,"待补全","_wait_insert"),
    UPDATE(20000,"更新","_update"),
    ;

    public Integer code;
    public String msg;
    public String key;

    cognitiveEnum(Integer code, String msg, String key) {
        this.code = code;
        this.msg = msg;
        this.key = key;
    }
}
