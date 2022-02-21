package com.example.hardcoredemo.modular.cognitive.service;

import com.example.hardcoredemo.modular.cognitive.common.entity.method.MethodParser;
import com.example.hardcoredemo.modular.cognitive.common.enums.CognitiveEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodService {

    private volatile MethodParser methodParser;

    public MethodService(MethodParser methodParser) {
        this.methodParser = methodParser;
    }

    //方法查询
    public List<Map<String, Object>> select(String name){
        List<Map<String, Object>> result = new ArrayList<>();
        this.select0(name, result);
        return result;
    }

    private void select0(String name0, List<Map<String, Object>> result){
        Map<String, Object> method = (Map<String, Object>) methodParser.getValue(name0);
        List<Map<String, Object>> childList = (List<Map<String, Object>>) method.get(CognitiveEnum.METHOD.key);
        if(null == childList){
            result.add(method);
        }else {
            for (Map<String, Object> c : childList) {
                String name = (String) c.get(CognitiveEnum.KEY.key);
                this.select0(name, result);
            }
        }
    }

    //方法执行
    public Object doing(List<Map<String, Object>> methods){
        Map<String, Object> result = new HashMap<>();
        for(Map<String, Object> method : methods){
            this.doing0(result);
        }
        return result;
    }

    private void doing0(Map<String, Object> result){

    }

    public static boolean if0(Object obj1, Object obj2, String symbol){
        if("=".equals(symbol)){
            return obj1.equals(obj2);
        }
        return false;
    }

    public static Object for0(Object obj){
        List list = (List) obj;
        List result = new ArrayList();
        for (Object obj0 : list){
            result.add(obj0);
        }
        return result;
    }

    public static Object find0(List<?> params){
        return new Object();
    }

}
