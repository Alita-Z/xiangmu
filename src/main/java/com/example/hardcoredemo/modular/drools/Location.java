package com.example.hardcoredemo.modular.drools;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location implements java.io.Serializable {
    static final long serialVersionUID = 1L;
    @org.kie.api.definition.type.Label(value = "\u56FD\u5BB6")
    private String country;
    @org.kie.api.definition.type.Label(value = "\u7701\u4EFD")
    private String province;
    @org.kie.api.definition.type.Label(value = "\u57CE\u5E02")
    public String city;
}
