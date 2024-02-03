package com.example.hardcoredemo.modular.cognitive.common.entity;

import com.example.hardcoredemo.modular.cognitive.common.entity.obj.AbstractMetaObj;
import lombok.Data;

/**
 * 类别解析器
 * @desc 用于定义thing之间抽象的多维度关联关系
 */
@Data
public class TypeParser extends AbstractMetaObj {

    public Object find(String id){
        return new Object();
    }

}
