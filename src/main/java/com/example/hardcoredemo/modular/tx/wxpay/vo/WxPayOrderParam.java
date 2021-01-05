package com.example.hardcoredemo.modular.tx.wxpay.vo;

import lombok.Data;

/**
 * 微信统一下单请求参数
 */
@Data
public class WxPayOrderParam {
    private String appid; // 公众账号ID
    private String mchId; // 微信支付 商户号
    private String deviceInfo; //非必填 设备号  终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
    private String nonceStr; // 随机字符串
    private String sign; // 签名
    private String body; // 商品描述  商品或支付简要描述
    private String detail; // 商品名称 明细列表
    private String attach; // 非必填 附加数据， 在查询Api和支付通知中 原样返回，该字段主要用于商户携带订单的自定义数据
    private String outTradeNo; // 商户订单号， 商户内部系统的订单号，  32个字符内，可包含字母。 微信支付要求商户订单号保持唯一性
    private String feeType; //非必填 默认人民币  CNY
    private int totalFee; // 订单总金额，单位为分
    private String spbillCreateIp; //  app和网页支付提交用户Id，native支付填调用微信支付Api的机器IP
    private String timeStart; //  非必填  交易开始时间  格式为yyyyMMddHHmmss
    private String timeExpire;// 非必填   交易结束时间  格式为yyyyMMddHHmmss
    private String goodsTag;// 非必填  商品标记，代金券或立减优惠功能的参数
    private String notifyUrl;// 通知地址， 接受微信支付异步通知回调地址，不能携带参数。
    private String tradeType;// 交易类型，  JSAPI,NATIVE,APP
    private String productId; // 非必填  商品Id trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
    private String limitPay; // 非必填  指定支付方式  no_credit--指定不能使用信用卡支付
    private String openid; // 非必填 trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取
}
