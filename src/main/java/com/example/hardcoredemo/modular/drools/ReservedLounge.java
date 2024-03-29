package com.example.hardcoredemo.modular.drools;

import lombok.Data;

@Data
public class ReservedLounge implements java.io.Serializable {
    static final long serialVersionUID = 1L;
    @org.kie.api.definition.type.Label("产品编码")
    private String proCode;
    @org.kie.api.definition.type.Label("产品名称")
    private String proName;
    @org.kie.api.definition.type.Label("位置")
    public Location location;
    @org.kie.api.definition.type.Label("是否自营")
    private boolean selfSupport;
}
