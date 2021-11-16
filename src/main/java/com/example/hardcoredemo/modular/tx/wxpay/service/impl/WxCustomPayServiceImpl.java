package com.example.hardcoredemo.modular.tx.wxpay.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.hardcoredemo.modular.tx.wxpay.service.WxCustomPayService;
import com.example.hardcoredemo.modular.tx.wxpay.utils.LocalIPUtil;
import com.example.hardcoredemo.modular.tx.wxpay.vo.WxJsapiPayVo;
import com.example.hardcoredemo.modular.tx.wxpay.vo.WxNativePayVo;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.order.WxPayNativeOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

@Slf4j
@Service
public class WxCustomPayServiceImpl implements WxCustomPayService {

//    @Autowired
    WxPayService wxPayService;

    /**
     * 支付 回调url
     */
    @Value("${weixin.pay.notifyUrl}")
    private String payNotifyUrl;

    /**
     * 订单标题
     */
    @Value("${weixin.pay.body}")
    private String WxBody;

    @Override
    public String WxNativePay(WxNativePayVo wxNativePayVo) {
        try {
            //解决中文标题乱码
            String body1 = new String(WxBody.getBytes("iso8859-1"),"gb2312");
            WxPayUnifiedOrderRequest request = WxPayUnifiedOrderRequest.newBuilder()
                    .spbillCreateIp(LocalIPUtil.getLocalAddr())
                    .outTradeNo(String.valueOf(wxNativePayVo.getPayId()))
                    .totalFee(wxNativePayVo.getTotalAmount().multiply(new BigDecimal("100")).intValue())
                    .productId(String.valueOf(wxNativePayVo.getProducdId()))
                    .body(body1)
                    .tradeType("NATIVE")
                    .notifyUrl(payNotifyUrl)
                    .build()
                    ;
            log.info("NATIVE支付........");
            WxPayNativeOrderResult wxPayUnifiedOrderResult = wxPayService.createOrder(request);
            return JSON.toJSONString(wxPayUnifiedOrderResult);
        } catch (WxPayException | UnsupportedEncodingException e) {
            log.error("微信支付失败！订单号：{},原因:{}", String.valueOf(wxNativePayVo.getPayId()), e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String WxJsapiPay(WxJsapiPayVo wxJsapiPayVo) {
        try {
            //解决中文标题乱码
            String body1 = new String(WxBody.getBytes("iso8859-1"),"gb2312");
            WxPayUnifiedOrderRequest request = WxPayUnifiedOrderRequest.newBuilder()
                    .spbillCreateIp(LocalIPUtil.getLocalAddr())
                    .outTradeNo(String.valueOf(wxJsapiPayVo.getPayId()))
                    .totalFee(wxJsapiPayVo.getTotalAmount().multiply(new BigDecimal("100")).intValue())
                    .productId(String.valueOf(wxJsapiPayVo.getProducdId()))
                    .body(body1)
                    .openid(wxJsapiPayVo.getOpenId())
                    .tradeType("JSAPI")
                    .notifyUrl(payNotifyUrl)
                    .build()
                    ;
                log.info("JSAPI支付........");
                WxPayMpOrderResult wxPayAppOrderResult= wxPayService.createOrder(request);
                return JSON.toJSONString(wxPayAppOrderResult);
        } catch (WxPayException | UnsupportedEncodingException e) {
            log.error("微信支付失败！订单号：{},原因:{}", String.valueOf(wxJsapiPayVo.getPayId()), e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
