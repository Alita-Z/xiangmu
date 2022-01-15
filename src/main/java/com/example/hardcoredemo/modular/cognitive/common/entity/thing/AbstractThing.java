package com.example.hardcoredemo.modular.cognitive.common.entity.thing;

import lombok.Data;

@Data
public class AbstractThing extends Thing {

    private ThingType type;
    private ThingConcept concept;
    private ThingRelationship relationship;
}
