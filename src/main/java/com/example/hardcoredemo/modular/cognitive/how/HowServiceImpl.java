package com.example.hardcoredemo.modular.cognitive.how;

import com.example.hardcoredemo.modular.cognitive.common.entity.CharParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.KonwRuleParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.TypeParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HowServiceImpl implements HowInterface {

    @Autowired
    private volatile KonwRuleParser ruleParser;

    @Autowired
    private volatile TypeParser typeParser;

    @Autowired
    private volatile CharParser charParser;

    @Override
    public Object how(HowObject object) {
        Object result0 = charParser.find(object.toString());
        return this.how0(result0);
    }

    private Object how0(Object object) {
        List<Object> beAffairs = (List<Object>) object;
        Map beAffair = (TreeMap) beAffairs;
        //语义分析

        //rule拼装

        //查询

        //结果拼装
        Object result = new Object();
        return result;
    }
}
