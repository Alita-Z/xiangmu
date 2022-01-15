package com.example.hardcoredemo.modular.cognitive.common.entity.obj;


import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AbstractObj {

    private final Map<String, Object> _otherParser = new ConcurrentHashMap<>();

    private final Map<String, PropertyDescriptor> _descMap = new ConcurrentHashMap<>();

    public synchronized void setValue(String key, Object value) {
        PropertyDescriptor descriptor = this.flash(false).get(key);
        if (descriptor != null) {
            try {
                descriptor.getWriteMethod().invoke(this, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        _otherParser.put(key, value);
    }

    public Object getValue(String key) {
        Object p = null;
        PropertyDescriptor descriptor = this.flash(false).get(key);
        if(descriptor != null){
            try {
                p = descriptor.getReadMethod().invoke(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (p == null) {
            p = _otherParser.get(key);
        }
        return p;
    }

    /**
     * 刷新
     * @param flash 是否刷新
     * @return _descMap
     */
    protected Map<String, PropertyDescriptor> flash(boolean flash) {
        if(_descMap.isEmpty() || flash){
            PropertyDescriptor[] propertys = null;
            try {
                propertys = Introspector.getBeanInfo(this.getClass()).getPropertyDescriptors();
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
            if (propertys == null || propertys.length == 0) {
                return _descMap;
            }
            for (PropertyDescriptor prop : propertys) {
                String name = prop.getName();
                if(name.startsWith("_")){
                    continue;
                }
                _descMap.put(name, prop);
            }
        }
        return _descMap;
    }

    public void init(Object obj){
        Map<String, Object> map = (Map) obj;
        for(String key : map.keySet()){
            setValue(key, map.get(key));
        }
    }
}
