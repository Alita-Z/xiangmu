package com.example.hardcoredemo.modular.drools;

import lombok.Data;
import org.drools.compiler.kproject.ReleaseIdImpl;
import org.kie.api.builder.ReleaseId;
import org.kie.api.management.GAV;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class Car  implements java.io.Serializable {
    private String name;

    private List<String> roads = new ArrayList<String>();

    private String begin;

    private String ends;

    private double carHigh;

    private double carWeight;

    private void test(){
        roads.size();
    }

}
