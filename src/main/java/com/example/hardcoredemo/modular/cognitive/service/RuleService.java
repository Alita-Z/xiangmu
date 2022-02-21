package com.example.hardcoredemo.modular.cognitive.service;

import com.example.hardcoredemo.dao.RuleMapper;
import com.example.hardcoredemo.modular.cognitive.common.entity.CharParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.KonwRuleParser;
import com.example.hardcoredemo.modular.cognitive.common.enums.CognitiveEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RuleService {

    @Autowired
    private volatile KonwRuleParser ruleParser;

    @Autowired
    private volatile CharParser charParser;

    private final RuleMapper ruleMapper;

    private final TypeService typeService;


    public RuleService(RuleMapper ruleMapper, TypeService typeService) {
        this.ruleMapper = ruleMapper;
        this.typeService = typeService;
    }

    /**
     * 语义解析
     * @param list
     * @return
     */
    public List<Map<String, Object>> analysis(List<Map<String, Object>> list){
        List<Map<String, Object>> resultList = new ArrayList<>();
        for(int i = 0; i < list.size();){
            Map<String, Object> map = list.get(i);
            List<String> preconditions = new ArrayList(map.size());
            Map<String, Object> analysis0Map = new HashMap<>();
            for(String key : map.keySet()){
                if(CognitiveEnum.VALUE.key.equals(key) || preconditions.contains(key))continue;
                //递归遍历relation
                recursion(preconditions, key, map, analysis0Map);
                //根据charMeta拆解数据
                Map<String, Object> params = new HashMap<>();
                params.put(CognitiveEnum.INDEX.key, i);
                params.put(CognitiveEnum.VALUE.key, map.get(CognitiveEnum.VALUE.key));
                params.put(CognitiveEnum.CHAR_META.key, charParser.getMetaValue(key));
                this.analysis0(params, analysis0Map);
                preconditions.add(key);
                if((boolean)analysis0Map.get(CognitiveEnum.OK.key)){
                    break;
                }
            }
            //单字符解析整理
            Map<String, Object> result = formatAnalysis(analysis0Map);
            if(result.isEmpty()){
                //未匹配到，标记-补充

            }else {
                resultList.add(result);
            }
            i = (int)result.get(CognitiveEnum.INDEX.key);
        }

        return resultList;
    }

    /**
     * 递归遍历relation
     * @param preconditions
     * @param key
     * @param map
     * @param analysis0Map
     * @return
     */
    private void recursion(List<String> preconditions, String key, Map<String, Object> map, Map<String, Object> analysis0Map){
        Map<String, Object> meta = charParser.getMetaValue(key);
        String[] precondition = (String[]) meta.get(CognitiveEnum.PRECONDITIONS.key);
        if(precondition.length > 0){
            for(String preconditionKey : precondition){
                if(preconditions.contains(preconditionKey))continue;
                //递归遍历relation
                recursion(preconditions, preconditionKey, map, analysis0Map);
                //根据charMeta拆解数据
                Map<String, Object> params = new HashMap<>();
                params.put(CognitiveEnum.VALUE.key, map.get(CognitiveEnum.VALUE.key));
                params.put(CognitiveEnum.CHAR_META.key, charParser.getMetaValue(preconditionKey));
                this.analysis0(params, analysis0Map);
                preconditions.add(preconditionKey);
            }
        }
    }

    /**
     * 返回值整理
     * @param analysis0Map
     * @return
     */
    private Map<String, Object> formatAnalysis(Map<String, Object> analysis0Map){
        Map<String, Object> result = new HashMap<>();
        result.put(CognitiveEnum.INDEX.key, analysis0Map.get(CognitiveEnum.INDEX.key));

        return result;
    }

    /**
     * 执行方法匹配
     * @param params
     * @param analysis0Map
     */
    private void analysis0(Map<String, Object> params, Map<String, Object> analysis0Map){
        Map<String, Object> charMeta = (Map<String, Object>) params.get(CognitiveEnum.CHAR_META.key);
        switch ((String) charMeta.get(CognitiveEnum.METHOD.key)){
            case "":
                ambiguity(params,analysis0Map);
                break;
            default:
                break;
        }
    }

    /**
     * 具体的方法
     * @param obj
     * @param result
     */
    private void ambiguity(Map<String, Object> obj, Map<String, Object> result){

    }

    public Map<String, Object> select(List<Map<String, Object>> list){
        Map<String, Object> result = new HashMap<>();
        for(Map<String, Object> map : list){

            Object obj = typeService.select(map);

        }
        result = (Map<String, Object>) select0(list);
        return result;
    }

    private Object select0(Object obj){
        Object result = null;
        String type = obj.toString();
        switch (type) {
            case "" :
                result = callMethod(obj);
                break;
            default:

        }
        return result;
    }

    private Object callMethod(Object obj){
        Object result;
        for(;;){
            try {
                result = callMethod0(obj);
                break;
            } catch (Exception e) {
//            e.printStackTrace();
//                continue;
            }
        }
        return result;
    }

    /**
     *     ClassNotFoundException,
     *     NoSuchMethodException,
     *     IllegalAccessException,
     *     InstantiationException,
     *     InvocationTargetException
     */
    private Object callMethod0(Object obj) throws Exception {
        Object result;
        Class<?> clazz = Class.forName("");
        Method method = clazz.getMethod("");
        int modifiers = method.getModifiers();
        if(Modifier.isStatic(modifiers)){
            result = method.invoke(obj);
        }else {
            result = method.invoke(clazz.newInstance(), obj);
        }
        return result;
    }

    public void format(Object obj){

    }
}
