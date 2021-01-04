package com.example.hardcoredemo.modular.tx.wxpay.service;

import com.example.hardcoredemo.modular.tx.wxpay.vo.WxPayVo;

public interface WxCustomPayService {

    /**
     * 微信支付
     * @param WxPayVo
     * @return
     */
    String WxPay(WxPayVo WxPayVo);

}
