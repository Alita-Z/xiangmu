package com.example.hardcoredemo.modular.tx.wxpay.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 微信统一下单Vo
 */
@Data
public class WxPayVo {

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
     * 来源0:未知、1:小程序、2：后台下单
     */
    private Integer source;

    /**
     * 商品标识
     */
    private Integer producdId;
}
