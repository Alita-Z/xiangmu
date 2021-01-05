package com.example.hardcoredemo.modular.tx.wxpay.vo;

import lombok.Data;

@Data
public class WxRefundVO {

    /**
     * 客户订单号
     */
    private String outTradeNo;

    /**
     * 退款单号
     */
    private String outRefundNo;

    /**
     * 总金额
     */
    private Integer totalFee;

    /**
     * 退款总金额
     */
    private Integer refundFee;
}
