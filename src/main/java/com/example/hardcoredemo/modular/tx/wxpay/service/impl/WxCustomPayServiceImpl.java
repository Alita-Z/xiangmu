package com.example.hardcoredemo.modular.tx.wxpay.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.hardcoredemo.modular.tx.wxpay.service.WxCustomPayService;
import com.example.hardcoredemo.modular.tx.wxpay.utils.LocalIPUtil;
import com.example.hardcoredemo.modular.tx.wxpay.vo.WxPayVo;
import com.github.binarywang.wxpay.bean.order.WxPayMpOrderResult;
import com.github.binarywang.wxpay.bean.order.WxPayNativeOrderResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

@Slf4j
public class WxCustomPayServiceImpl implements WxCustomPayService {

    @Autowired
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
    public String WxPay(WxPayVo wxPayVo) {
        try {
            String body1 = new String(WxBody.getBytes("iso8859-1"),"gb2312");
            WxPayUnifiedOrderRequest request = WxPayUnifiedOrderRequest.newBuilder()
                    .spbillCreateIp(LocalIPUtil.getLocalAddr())
                    .outTradeNo(String.valueOf(wxPayVo.getPayId()))
                    .totalFee(wxPayVo.getTotalAmount().multiply(new BigDecimal("100")).intValue())
                    .productId(String.valueOf(wxPayVo.getProducdId()))
                    .body(body1)
                    .notifyUrl(payNotifyUrl)
                    .build()
                    ;
            String type = "NATIVE";
            log.info("接收到的支付类型为:{}", wxPayVo.getSource());
            // JSAPI支付
            if(new Integer(1).equals(wxPayVo.getSource())){
                type = "JSAPI";
                //类型为JSPAI时openId为必须传
                request.setOpenid(wxPayVo.getOpenId());
                request.setTradeType(type);
                WxPayMpOrderResult wxPayAppOrderResult= wxPayService.createOrder(request);
                log.info("JSAPI支付........");
                return JSON.toJSONString(wxPayAppOrderResult);
            }
            request.setTradeType(type);
            log.info("NATIVE支付........");
            WxPayNativeOrderResult wxPayUnifiedOrderResult = wxPayService.createOrder(request);
            return JSON.toJSONString(wxPayUnifiedOrderResult);
        } catch (WxPayException | UnsupportedEncodingException e) {
            log.error("微信支付失败！订单号：{},原因:{}", String.valueOf(wxPayVo.getPayId()), e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
