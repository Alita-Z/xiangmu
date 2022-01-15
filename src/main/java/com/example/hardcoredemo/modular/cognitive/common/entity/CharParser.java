package com.example.hardcoredemo.modular.cognitive.common.entity;

import com.example.hardcoredemo.modular.cognitive.common.entity.obj.AbstractMetaObj;
import com.example.hardcoredemo.modular.cognitive.common.enums.cognitiveEnum;
import lombok.Data;

import java.util.*;

/**
 * 字符解析器
 */
@Data
public class CharParser extends AbstractMetaObj {

    //对单字符解析
    public Object find(String case0){
        List<Object> result = new ArrayList<>();
        char[] charArray = case0.toCharArray();
        for (char c : charArray) {
            Object iChar0 = this.find0(c);
            result.add(iChar0);
        }
        return result;
    }

    private Object find0(char char0){
        Map result = null;
        //查询字符对应的char类型
        result = (Map) this.getValue(String.valueOf(char0));
        //标记待补全char
        if(null == result){
            result = new HashMap();
            result.put(cognitiveEnum.WAIT_INSERT.key, "");
        }
        return result;
    }
}
