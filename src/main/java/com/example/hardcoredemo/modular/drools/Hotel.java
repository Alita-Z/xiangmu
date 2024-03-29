package com.example.hardcoredemo.modular.drools;

import lombok.Data;

@Data
public class Hotel implements java.io.Serializable {
    static final long serialVersionUID = 1L;
    @org.kie.api.definition.type.Label("产品编码")
    private String proCode;
    @org.kie.api.definition.type.Label("产品名称")
    private String proName;
    @org.kie.api.definition.type.Label("房型")
    private String roomType;
    @org.kie.api.definition.type.Label("入住日期")
    private java.util.Date checkInDate;
    @org.kie.api.definition.type.Label("位置")
    public Location location;
    @org.kie.api.definition.type.Label(value = "\u662F\u5426\u53EF\u6253\u5305\u9500\u552E")
    private Boolean ifCanPackageSale;
}
