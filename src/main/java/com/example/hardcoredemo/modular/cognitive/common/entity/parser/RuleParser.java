package com.example.hardcoredemo.modular.cognitive.common.entity.parser;

import com.example.hardcoredemo.modular.cognitive.common.entity.obj.AbstractMetaObj;
import lombok.Data;

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

    public Object getRule(Object result0, Object result1){

        return this;
    }

}
