package com.example.hardcoredemo.modular.ali.alipay.service.impl;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.example.hardcoredemo.common.enums.ResultCode;
import com.example.hardcoredemo.common.exception.BaseException;
import com.example.hardcoredemo.modular.ali.alipay.service.AliCustomRefundService;
import com.example.hardcoredemo.modular.ali.alipay.vo.AlRefundNotifyResult;
import com.example.hardcoredemo.modular.ali.alipay.vo.AliRefundVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class AliCustomRefundServiceImpl implements AliCustomRefundService {

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    @Value("${zhifubao.appId}")
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

    @Override
    public void AliRefund(AliRefundVo aliRefundVO) {
        log.info("进入支付宝退款接口.......................");
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl, alAppId, merchantPrivateKey, format, charset, alipayPublicKey, signType);
        //设置请求参数
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
        AlipayTradeRefundModel model = new AlipayTradeRefundModel();
        model.setOutTradeNo(aliRefundVO.getOutTradeNo());//商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复
        model.setRefundAmount(aliRefundVO.getRefundFee()); //退款金额
        model.setOutRequestNo(aliRefundVO.getOutRefundNo());//标识一次退款请求，同一笔交易多次退款需要保证唯一。
        alipayRequest.setBizModel(model);
        AlipayTradeRefundResponse execute;
        try {
            execute  = alipayClient.execute(alipayRequest);
            AlRefundNotifyResult refundResponseSign = JSON.parseObject(execute.getBody(),AlRefundNotifyResult.class);
            if(execute.isSuccess()){
                //调用退款业务处理
                log.info("********************** 退款成功(支付宝) **********************");
                log.info("* 订单号: {}", execute.getTradeNo());
                log.info("* 实付金额: {}", execute.getRefundFee());
                log.info("***************************************************************");
            }else {
                refundResponseSign.getCode();
                log.error("********************** 退款失败(支付宝) **********************");
                log.error("* 状态码: {}", refundResponseSign.getSubCode());
                log.error("* 错误信息: {}", refundResponseSign.getSubMsg());
                log.error("***************************************************************");
                throw new BaseException(ResultCode.REFUND_PAY_FAIL);
            }
        } catch (AlipayApiException e) {
            log.error("支付宝退款出错了！,{},{}" , e.getErrCode() ,e.getErrMsg());
            throw new BaseException(ResultCode.REFUND_PAY_FAIL);
        }
    }
}

