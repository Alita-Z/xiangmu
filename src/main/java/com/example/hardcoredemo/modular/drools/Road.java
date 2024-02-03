package com.example.hardcoredemo.modular.drools;

import lombok.Data;

import java.util.Map;

@Data
public class Road implements java.io.Serializable {
    @org.kie.api.definition.type.Label("开始位置")
    private String begin;

    private String ends;

    private double carHigh;

    private double carWeight;

    private int roadType;
}
