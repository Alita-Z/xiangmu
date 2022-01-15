package com.example.hardcoredemo.modular.cognitive.common.entity.thing;

import com.example.hardcoredemo.modular.cognitive.common.entity.obj.AbstractObj;
import lombok.Data;

@Data
public class Thing extends AbstractObj {

    private ThingTime time;
    private ThingSpace space;

}
