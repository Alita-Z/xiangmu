package com.example.hardcoredemo.modular.tx.wxapplets;

import java.util.HashMap;
import java.util.Map;

public enum MessageType {

    PAY(1,"********************************", "付款通知"),
    PUSH(2,"********************************", "推送通知"),
    ;

    public Integer code;
    //模板id
    public String key;
    public String desc;

    MessageType(int code, String key, String desc) {
        this.code = code;
        this.key = key;
        this.desc = desc;
    }

    public static Map<String, MessageValue> formatPAY(String thing1, String amount2, String thing4){
        Map<String, MessageValue> dataMap = new HashMap<>();
        dataMap.put("thing1",new MessageValue().setValue(thing1));//商品名称
        dataMap.put("amount2",new MessageValue().setValue(amount2));//付款金额
        dataMap.put("thing4",new MessageValue().setValue(thing4));//温馨提示
        return dataMap;
    }

    public static Map<String, MessageValue> formatPUSH(String thing1, String amount2, String thing4){
        Map<String, MessageValue> dataMap = new HashMap<>();
        dataMap.put("thing1",new MessageValue().setValue(thing1));//商品名称
        dataMap.put("amount2",new MessageValue().setValue(amount2));//付款金额
        dataMap.put("thing4",new MessageValue().setValue(thing4));//温馨提示
        return dataMap;
    }

    static class MessageValue {
        private String value;
        public MessageValue setValue(String value){
            this.value = value;
            return this;
        }
    }
}
