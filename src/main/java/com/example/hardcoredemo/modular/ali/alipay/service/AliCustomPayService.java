package com.example.hardcoredemo.modular.ali.alipay.service;

import com.example.hardcoredemo.modular.ali.alipay.vo.AliPayVo;

public interface AliCustomPayService {

    /**
     * 阿里支付
     * @param aliPayVo
     * @return
     */
    String AliPay(AliPayVo aliPayVo);

}
