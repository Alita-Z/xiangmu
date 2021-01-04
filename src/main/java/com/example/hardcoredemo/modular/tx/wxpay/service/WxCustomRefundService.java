package com.example.hardcoredemo.modular.tx.wxpay.service;

import com.example.hardcoredemo.modular.tx.wxpay.vo.WxRefundVO;

public interface WxCustomRefundService {

    /**
     * 微信退款
     * @param wxRefundVO
     * @return
     */
    void WxRefund(WxRefundVO wxRefundVO);
}
