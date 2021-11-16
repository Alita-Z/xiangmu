package com.example.hardcoredemo.modular.tx.wxpay.controller;

import com.alipay.api.internal.util.file.IOUtils;
import com.example.hardcoredemo.common.base.BaseController;
import com.example.hardcoredemo.common.base.ParentBaseController;
import com.example.hardcoredemo.modular.tx.wxpay.utils.BeanUtil;
import com.example.hardcoredemo.modular.tx.wxpay.utils.XmlUtil;
import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/wx")
@Slf4j
public class WxPayController extends ParentBaseController {


//    @Autowired
    WxPayService wxPayService;

    /**
     * 微信支付回调接口
     */
    @RequestMapping(value = "/wxPayCallBack")
    public String WxPayCallBack(HttpServletRequest request)  {
        log.info("进入微信支付回调");
        String sucess = null;
        String fail = null;
        try {
            WxPayNotifyResponse wxPayNotifyResponse = new WxPayNotifyResponse();
            wxPayNotifyResponse.setReturnCode("SUCCESS");
            wxPayNotifyResponse.setReturnMsg("OK");
            Map<String, Object> data = BeanUtil.object2Map(wxPayNotifyResponse);
            sucess = XmlUtil.toXml(data);

            WxPayNotifyResponse wxPayNotifyResponse1 = new WxPayNotifyResponse();
            wxPayNotifyResponse.setReturnCode("FAIL");
            wxPayNotifyResponse.setReturnMsg("");
            Map<String, Object> data1 = BeanUtil.object2Map(wxPayNotifyResponse1);
            fail = XmlUtil.toXml(data1);

            String xmlData = IOUtils.toString(request.getInputStream());
            final WxPayOrderNotifyResult notifyResult = wxPayService.parseOrderNotifyResult(xmlData);
            //支付回调后的业务处理-请自行编写




            log.info("********************** 支付成功(微信异步通知) **********************");
            log.info("* 订单号: {}", notifyResult.getOutTradeNo());
            log.info("* 实付金额: {}", notifyResult.getTotalFee());
            log.info("***************************************************************");
        } catch (IOException | WxPayException e) {
            e.printStackTrace();
            log.error("支付回调失败：{}", e);
            return fail;
        }
        log.info("支付回调成功");
        return sucess;
    }

    /**
     * 微信退款回调接口
     */
    @RequestMapping(value = "/wxRefundCallBack")
    public String WxRefundCallBack(HttpServletRequest request) {
        log.info("进入微退款回调接口");
        String sucess = null;
        String fail = null;
        String xmlData = null;
        try {
            WxPayNotifyResponse wxPayNotifyResponse = new WxPayNotifyResponse();
            wxPayNotifyResponse.setReturnCode("SUCCESS");
            wxPayNotifyResponse.setReturnMsg("OK");
            Map<String, Object> data = BeanUtil.object2Map(wxPayNotifyResponse);
            sucess = XmlUtil.toXml(data);

            WxPayNotifyResponse wxPayNotifyResponse1 = new WxPayNotifyResponse();
            wxPayNotifyResponse.setReturnCode("FAIL");
            wxPayNotifyResponse.setReturnMsg("");
            Map<String, Object> data1 = BeanUtil.object2Map(wxPayNotifyResponse1);
            fail = XmlUtil.toXml(data1);

            xmlData = IOUtils.toString(request.getInputStream());

            final WxPayRefundNotifyResult wxPayRefundNotifyResult = wxPayService.parseRefundNotifyResult(xmlData);
            //退款回调后的业务处理-请自行编写



            log.info("********************** 退款成功(微信异步通知) **********************");
            log.info("* 订单号: {}", wxPayRefundNotifyResult.getReqInfo().getOutTradeNo());
            log.info("* 退款金额: {}", wxPayRefundNotifyResult.getReqInfo().getRefundFee());
            log.info("***************************************************************");
        } catch (WxPayException | IOException e) {
            log.error("退款回调失败:{}",e);
            return fail;
        }
        log.info("退款回调成功");
        return sucess;
    }

}
