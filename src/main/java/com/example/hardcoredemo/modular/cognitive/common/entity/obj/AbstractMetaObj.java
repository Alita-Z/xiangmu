package com.example.hardcoredemo.modular.cognitive.common.entity.obj;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AbstractMetaObj extends AbstractObj {

    private Map<String, Map<String, Object>> _metaMap = new ConcurrentHashMap<>();

    public synchronized void setMetaValue(String key, Map<String, Object> value) {
        _metaMap.put(key, value);
    }

    public Map<String, Object> getMetaValue(String key) {
        return _metaMap.get(key);
    }

    public void init(Object obj, Object metaObj){
        super.init(obj);
        Map<String, Map<String, Object>> map = (Map) metaObj;
        for(String key : map.keySet()){
            _metaMap.put(key, map.get(key));
        }
    }
}
