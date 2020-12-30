package com.example.hardcoredemo.common.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum PostType {

    JSON(1, "JSON格式"),
    XML(2, "XML格式"),
    ;

    public Integer code;
    public String desc;

    PostType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static List<Map> getList(){
        List<Map> list = new ArrayList();
        for(PostType status : PostType.values()){
            Map map = new HashMap();
            map.put("code",status.code);
            map.put("desc",status.desc);
            list.add(map);
        }
        return list;
    }
}
