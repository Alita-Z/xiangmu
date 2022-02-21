package com.example.hardcoredemo.modular.cognitive.why;

import com.example.hardcoredemo.modular.cognitive.common.entity.CharParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.KonwRuleParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.TypeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WhyServiceImpl implements WhyInterface{

    @Autowired
    private volatile KonwRuleParser ruleParser;

    @Autowired
    private volatile TypeParser typeParser;

    @Autowired
    private volatile CharParser charParser;

    @Override
    public Object why(WhyObject object) {
        List<Map<String, Object>> result0 = charParser.find(object.toString());
        return why0(result0);
    }

    private Object why0(List<Map<String, Object>> list){
        //语义分析

        //rule拼装

        //查询

        //结果拼装
        Object result = new Object();
        return result;
    }
}
