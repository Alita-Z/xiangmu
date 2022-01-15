package com.example.hardcoredemo.modular.cognitive.config;

import com.alibaba.fastjson.JSON;
import com.example.hardcoredemo.common.utils.ApplicationContextProvider;
import com.example.hardcoredemo.modular.cognitive.common.entity.CharParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.KonwRuleParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.parser.RuleParser;
import com.example.hardcoredemo.modular.cognitive.common.entity.TypeParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class beanInit {

    @Bean
    public CharParser charInit(){
        String charDB = ApplicationContextProvider.getBean("CharMapper").toString();
        CharParser charParser = (CharParser) JSON.parseArray(charDB, TypeParser.class);
        charParser.init(charParser);
        return charParser;
    }

    @Bean
    public KonwRuleParser ruleInit() throws Exception {
        String ruleDB = ApplicationContextProvider.getBean("RuleMapper").toString();
        KonwRuleParser ruleParser = (KonwRuleParser) JSON.parseArray(ruleDB, RuleParser.class);
        ruleParser.init(ruleParser);
        return ruleParser;
    }

    @Bean
    public TypeParser typeInit(){
        String typeDB = ApplicationContextProvider.getBean("TypeMapper").toString();
        TypeParser typeParser = (TypeParser) JSON.parseArray(typeDB, TypeParser.class);
        typeParser.init(typeParser);
        return typeParser;
    }
}
