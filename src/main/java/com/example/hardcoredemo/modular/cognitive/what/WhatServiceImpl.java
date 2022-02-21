package com.example.hardcoredemo.modular.cognitive.what;

import com.example.hardcoredemo.modular.cognitive.common.entity.CharParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.KonwRuleParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.parser.RuleParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.TypeParser;
import com.example.hardcoredemo.modular.cognitive.service.RuleService;
import com.example.hardcoredemo.modular.cognitive.service.TypeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WhatServiceImpl implements WhatInterface {

    @Autowired
    private volatile KonwRuleParser ruleParser;

    @Autowired
    private volatile TypeParser typeParser;

    @Autowired
    private volatile CharParser charParser;

    @Autowired
    private RuleService ruleService;

    @Autowired
    private TypeService typeService;

    @Override
    public void what(WhatObject object) {
        this.what0(object.getCase1(), object.getResult2());
    }

    @SneakyThrows
    private RuleParser what0(Object case1, Object result2) {
        List<Map<String, Object>> result0 = charParser.find(case1.toString());
        List<Map<String, Object>> result1 = charParser.find(result2.toString());
        //生成rule逻辑
        Object resultRule = ruleParser.getRule(result0, result1);
        //保存rule逻辑
        ruleParser.setValue("resultRule", resultRule);
        return ruleParser;
    }

}
