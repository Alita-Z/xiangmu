package com.example.hardcoredemo.modular.ali.alipay.service;

import com.example.hardcoredemo.modular.ali.alipay.vo.AliRefundVo;

public interface AliCustomRefundService {

    /**
     * 阿里退款
     * @param aliRefundVO
     * @return
     */
    void AliRefund(AliRefundVo aliRefundVO);
}
