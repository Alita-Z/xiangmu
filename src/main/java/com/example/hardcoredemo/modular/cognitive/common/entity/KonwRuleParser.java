package com.example.hardcoredemo.modular.cognitive.common.entity;

import com.example.hardcoredemo.modular.cognitive.common.entity.parser.RuleParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.parser.SoulParser;
import lombok.Data;

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
    public Object getRule(Object result0, Object result1){

        return this;
    }
}
