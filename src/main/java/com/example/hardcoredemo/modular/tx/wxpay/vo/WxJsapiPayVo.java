package com.example.hardcoredemo.modular.tx.wxpay.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 微信统一下单(Native)Vo
 */
@Data
public class WxJsapiPayVo {

    /**
     * 客户订单号
     */
    private String payId;

    /**
     * 下单金额
     */
    private BigDecimal totalAmount;

    /**
     * openId
     */
    private String openId;

    /**
     * 商品标识
     */
    private Integer producdId;
}
