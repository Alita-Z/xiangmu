package com.example.hardcoredemo.modular.cognitive.common.entity;

import com.example.hardcoredemo.modular.cognitive.common.entity.obj.AbstractObj;
import lombok.Data;

import java.util.List;

@Data
public class TypeObj extends AbstractObj {

    private String id;

    private String parentId;

    private String name;

    private List<String> nickname;

    private String desc;

    private Boolean sort;

    private String version;

}
