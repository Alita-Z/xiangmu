package com.example.hardcoredemo.modular.cognitive.service;

import com.example.hardcoredemo.modular.cognitive.common.entity.method.MethodParser;
import com.example.hardcoredemo.modular.cognitive.common.enums.CognitiveEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
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
    public Object action(List<Map<String, Object>> methods){
        Map<String, Object> result = new HashMap<>();
        for(Map<String, Object> method : methods){
            this.action0(method, result);
        }
        return result;
    }

    private void action0(Map<String, Object> method, Map<String, Object> result){

        switch ((String) result.get(CognitiveEnum.METHOD.key)){
            case "if":
                if0(method, result);
                break;
            case "for":
                for0(method, result);
                break;
            default:
                break;
        }
    }

    public static boolean if0(Map<String, Object> method, Map<String, Object> result){
        Object obj1 = method.get("");
        Object obj2 = method.get("");
        String symbol = (String) method.get("");
        if("=".equals(symbol)){
            result.put("", obj1.equals(obj2));
            return obj1.equals(obj2);
        }
        result.put("", false);
        return false;
    }

    public static Object for0(Map<String, Object> method, Map<String, Object> result){
        List list = (List) method.get("");
        List forList = new ArrayList();
        for (Object obj0 : list){
            forList.add(obj0);
        }
        result.put("", forList);
        return result;
    }

    public static Object find0(List<?> params){
        return new Object();
    }

}
