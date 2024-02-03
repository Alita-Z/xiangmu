package com.example.hardcoredemo.modular.cognitive.answer;

import com.example.hardcoredemo.modular.cognitive.common.entity.CharParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.KonwRuleParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.TypeParser;
import com.example.hardcoredemo.modular.cognitive.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AnswerServiceImpl implements AnswerInterface {

    @Autowired
    private volatile KonwRuleParser ruleParser;

    @Autowired
    private volatile TypeParser typeParser;

    @Autowired
    private volatile CharParser charParser;

    @Autowired
    private RuleService ruleService;

    @Override
    public Object answer(AnswerObject object) {
        List<Map<String, Object>> result0 = charParser.find(object.toString());
        return this.answer0(result0);
    }

    private Object answer0(List<Map<String, Object>> list) {
        //语义分析
        List<Map<String, Object>> ruleMap = ruleService.analysis(list);
        //根据语义处理数据
        Map<String, Object> selectMap = ruleService.select(ruleMap);
        //数据整理
        ruleService.format(selectMap);
        //结果拼装
        Object result;
        result = selectMap;
        return result;
    }
}
