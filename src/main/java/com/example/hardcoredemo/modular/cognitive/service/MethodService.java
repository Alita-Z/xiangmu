package com.example.hardcoredemo.modular.cognitive.service;

import java.util.ArrayList;
import java.util.List;

public class MethodService {

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
