package com.example.hardcoredemo.modular.cognitive.common.entity;

import com.example.hardcoredemo.modular.cognitive.common.entity.parser.RuleParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.parser.SoulParser;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 人认知解析器
 */
@Data
public class KonwRuleParser extends RuleParser {

    private Object visualParser;
    private Object auditoryParser;
    private Object olfactoryParser;
    private Object tasteParser;
    private Object tactileParser;

    private SoulParser soulParser;

    @Override
    public Object getRule(List<Map<String, Object>> result){

        return this;
    }

    @Override
    public Object getRule(List<Map<String, Object>> result0, List<Map<String, Object>> result1){

        return this;
    }
}
