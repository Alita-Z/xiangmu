package com.example.hardcoredemo.modular.tx.wxpay.service.impl;

import com.example.hardcoredemo.common.enums.ResultCode;
import com.example.hardcoredemo.common.exception.BaseException;
import com.example.hardcoredemo.modular.tx.wxpay.service.WxCustomRefundService;
import com.example.hardcoredemo.modular.tx.wxpay.vo.WxRefundVO;
import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class WxCustomRefundServiceImpl implements WxCustomRefundService {

//    @Autowired
    WxPayService wxPayService;

    /**
     * 退款 回调url
     */
    @Value("${weixin.refund.notifyUrl}")
    private String refundNotifyUrl;

    @Override
    public void WxRefund(WxRefundVO wxRefundVO) {
        if(null == wxRefundVO.getRefundFee()) return ;
        if(new BigDecimal(wxRefundVO.getRefundFee()).compareTo(BigDecimal.ZERO) <= 0) return;
        WxPayRefundRequest refundRequest = WxPayRefundRequest.newBuilder()
                .outTradeNo(wxRefundVO.getOutTradeNo())
                .outRefundNo(wxRefundVO.getOutRefundNo())
                .notifyUrl(refundNotifyUrl)
                .build();
        refundRequest.setTotalFee(wxRefundVO.getTotalFee());
        refundRequest.setRefundFee(wxRefundVO.getRefundFee());
        log.info("开始退款/结账:{}", refundRequest.toString());
        try{
            WxPayRefundResult result = wxPayService.refund(refundRequest);
            if("SUCCESS".equalsIgnoreCase(result.getResultCode())){
                log.info("退款/结账成功:{}", result.toString());
            }else{
                throw new BaseException(ResultCode.REFUND_PAY_FAIL);
            }
        }catch(WxPayException e){
            throw new BaseException(ResultCode.REFUND_PAY_FAIL);
        }
    }
}
