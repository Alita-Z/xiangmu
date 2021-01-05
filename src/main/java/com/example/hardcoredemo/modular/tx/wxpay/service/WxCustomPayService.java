package com.example.hardcoredemo.modular.tx.wxpay.service;

import com.example.hardcoredemo.modular.tx.wxpay.vo.WxJsapiPayVo;
import com.example.hardcoredemo.modular.tx.wxpay.vo.WxNativePayVo;

public interface WxCustomPayService {

    /**
     * 微信支付(JSAPI)
     * @param wxJsapiPayVo
     * @return
     */
    String WxJsapiPay(WxJsapiPayVo wxJsapiPayVo);

    /**
     * 微信支付(NATIVE)
     * @param wxNativePayVo
     * @return
     */
    String WxNativePay(WxNativePayVo wxNativePayVo);

}
