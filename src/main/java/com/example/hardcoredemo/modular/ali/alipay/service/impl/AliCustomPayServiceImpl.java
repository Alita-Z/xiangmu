package com.example.hardcoredemo.modular.ali.alipay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.example.hardcoredemo.common.enums.ResultCode;
import com.example.hardcoredemo.common.exception.BaseException;
import com.example.hardcoredemo.modular.ali.alipay.service.AliCustomPayService;
import com.example.hardcoredemo.modular.ali.alipay.vo.AliPayVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;

@Slf4j
public class AliCustomPayServiceImpl implements AliCustomPayService {

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    @Value("${ali.pay.appId}")
    private  String alAppId;

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    @Value("${ali.pay.merchantPrivateKey}")
    private  String merchantPrivateKey;

    /**
     * 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    @Value("${ali.pay.alipayPublicKey}")
    private  String alipayPublicKey;

    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    @Value("${ali.pay.notifyUrl}")
    private  String notifyUrl;

    /**
     * 签名方式
     */
    @Value("${ali.pay.signType}")
    private  String signType;

    /**
     * 字符编码格式
     */
    @Value("${ali.pay.charset}")
    private  String charset;

    /**
     * 支付宝网关
     */
    @Value("${ali.pay.gatewayUrl}")
    private  String gatewayUrl;

    /**
     * json格式
     */
    @Value("${ali.pay.format}")
    private String format;

    /**
     * 超时时间
     */
    @Value("${ali.pay.timeout}")
    private String timeout;

    /**
     * 订单标题
     */
    @Value("${ali.pay.body}")
    private String body;

    @Override
    public String AliPay(AliPayVo aliPayVo) {
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl, alAppId, merchantPrivateKey, format, charset, alipayPublicKey, signType);
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();

//        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        //设置回调函数地址
        request.setNotifyUrl(notifyUrl);
        //创建查询参数
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        //设置订单编号
        model.setOutTradeNo(aliPayVo.getPayId());
        //设置金额
        model.setTotalAmount(String.valueOf(aliPayVo.getTotalAmount()));
        //设置主题
        try {
            model.setSubject(new String(body.getBytes("iso8859-1"),"gb2312"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //设置支付超时时间
        model.setTimeoutExpress(timeout);
        request.setBizModel(model);
        AlipayTradePrecreateResponse responseData;
        try {
            responseData = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            log.info("支付宝生成二维码出错！,{},{}" , e.getErrCode() ,e.getErrMsg());
            throw new BaseException(ResultCode.ALIPAY_CREATE_QRCODE_EXCEPTION);
        }
        return responseData.getQrCode();
    }
}
