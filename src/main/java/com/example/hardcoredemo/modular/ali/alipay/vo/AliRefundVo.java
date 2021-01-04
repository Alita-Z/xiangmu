package com.example.hardcoredemo.modular.ali.alipay.vo;

import lombok.Data;

/**
 * 阿里退款Vo
 */
@Data
public class AliRefundVo {

    /**
     * 客户订单号
     */
    private String outTradeNo;

    /**
     * 退款单号
     */
    private String outRefundNo;

    /**
     * 退款总金额
     */
    private String refundFee;
}
