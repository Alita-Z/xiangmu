package com.example.hardcoredemo.modular.cognitive.service;

import com.example.hardcoredemo.dao.RuleMapper;
import com.example.hardcoredemo.modular.cognitive.common.entity.KonwRuleParser;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

    private volatile KonwRuleParser ruleParser;

    private final RuleMapper ruleMapper;

    public RuleService(RuleMapper ruleMapper, KonwRuleParser ruleParser) {
        this.ruleMapper = ruleMapper;
        this.ruleParser = ruleParser;
    }
}
