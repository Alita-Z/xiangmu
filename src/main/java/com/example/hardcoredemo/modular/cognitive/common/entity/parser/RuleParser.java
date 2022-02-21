package com.example.hardcoredemo.modular.cognitive.common.entity.parser;

import com.example.hardcoredemo.modular.cognitive.common.entity.obj.AbstractMetaObj;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 认知解析器
 */
@Data
public class RuleParser extends AbstractMetaObj {

    private ScientificParser scientificParser;

    /**
     * 初始化
     * @param ruleParser
     */
    public void init(RuleParser ruleParser) {
        ruleParser.flash(true);
    }

    public Object getRule(List<Map<String, Object>> result){

        return this;
    }

    public Object getRule(List<Map<String, Object>> result0, List<Map<String, Object>> result1){

        return this;
    }

}
