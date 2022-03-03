package com.example.hardcoredemo.modular.cognitive.common.enums;

public enum CognitiveEnum {
    INDEX(1,"索引值","_index"),
    KEY(2,"key","_key"),
    VALUE(3,"value值","_value"),
    METHOD(4,"方法","_method"),
    OK(5,"判断","_ok"),
    PRECONDITIONS(6,"前置条件","_preconditions"),

    INSERT(10000,"添加","_insert"),
    UPDATE(10001,"更新","_update"),
    WAIT_INSERT(10002,"待添加","_wait_insert"),
    WAIT_UPDATE(10003,"待更新","_wait_update"),

    CHAR_KEY(30000,"char字符","_char_key"),
    CHAR_META(30001,"char元数据","_char_meta"),
    THING_RELATION_KEY(30002,"相关联的key","_thing_relathion_key"),
    ;

    public Integer code;
    public String msg;
    public String key;

    CognitiveEnum(Integer code, String msg, String key) {
        this.code = code;
        this.msg = msg;
        this.key = key;
    }
}
