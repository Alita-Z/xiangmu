package com.example.hardcoredemo.modular.cognitive.service;

import com.example.hardcoredemo.dao.TypeMapper;
import com.example.hardcoredemo.modular.cognitive.common.entity.TypeParser;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

    private volatile TypeParser typeParser;

    private final TypeMapper typeMapper;

    public TypeService(TypeMapper typeMapper, TypeParser typeParser) {
        this.typeMapper = typeMapper;
        this.typeParser = typeParser;
    }

    public Object select(Object obj){
        return obj;
    }
}
