package com.example.hardcoredemo.modular.cognitive.common.entity;

import com.example.hardcoredemo.modular.cognitive.common.entity.obj.AbstractMetaObj;
import com.example.hardcoredemo.modular.cognitive.common.enums.CognitiveEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

/**
 * 字符解析器
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CharParser extends AbstractMetaObj {

    //对单字符解析
    public List<Map<String, Object>> find(String case0){
        List<Map<String, Object>> result = new ArrayList<>(case0.length());
        char[] charArray = case0.toCharArray();
        for (char c : charArray) {
            Map<String, Object> iChar0 = this.find0(c);
            result.add(iChar0);
        }
        return result;
    }

    private Map<String, Object> find0(char char0){
        Map<String, Object> result;
        //查询字符对应的char类型
        result = (Map) this.getValue(String.valueOf(char0));
        //标记待补全char
        if(null == result){
            result = new HashMap<>();
            result.put(CognitiveEnum.WAIT_INSERT.key, "");
        }
        return result;
    }

}
