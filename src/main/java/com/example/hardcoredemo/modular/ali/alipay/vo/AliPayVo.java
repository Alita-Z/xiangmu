package com.example.hardcoredemo.modular.ali.alipay.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 阿里下单Vo
 */
@Data
public class AliPayVo {

    /**
     * 客户订单号
     */
    private String payId;

    /**
     * 下单金额
     */
    private BigDecimal totalAmount;

    /**
     * 商品标识
     */
    private Integer producdId;
}
