package com.example.hardcoredemo.modular.cognitive.common.entity.thing;

import lombok.Data;

/**
 * 事物的抽象数据
 */
@Data
public class AbstractThing extends Thing {

    private String code;
    private ThingType type;
    private ThingConcept concept;
    private ThingRelationship relationship;
}
