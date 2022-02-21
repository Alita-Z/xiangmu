package com.example.hardcoredemo.modular.cognitive.common.enums;

public enum CognitiveEnum {
    INDEX(1,"索引值","_index"),
    VALUE(2,"value值","_value"),
    METHOD(3,"方法","_method"),
    OK(4,"判断","_ok"),
    PRECONDITIONS(5,"前置条件","_preconditions"),
    WAIT_INSERT(10000,"待补全","_wait_insert"),
    UPDATE(20000,"更新","_update"),
    CHAR_META(30000,"char元数据","_char_meta"),
    CHAR_KEY(40000,"char字符","_char_key"),
    THING_RELATION_KEY(50000,"相关联的key","_thing_relathion_key"),
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
