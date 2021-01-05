package com.example.hardcoredemo.modular.ali.alipay.vo;

import lombok.Data;

/**
 * 阿里退款响应实体
 */
@Data
public class AlRefundNotifyResult {
    //公共响应参数
    private String code; // 网关返回码
    private String msg;// 网关返回码描述
    private String subCode;// 网关返回码描述
    private String subMsg;// 网关返回码描述
    private String sign; // 签名

    //响应参数
    private String tradeNo;// 支付宝交易号

    private String outTradeNo;// 商户订单号

    private String buyerLogonId; //用户的登录id

    private String fundChange; // 本次退款是否发生了资金变化 Y/N
    private String refundFee; // 退款总金额


}