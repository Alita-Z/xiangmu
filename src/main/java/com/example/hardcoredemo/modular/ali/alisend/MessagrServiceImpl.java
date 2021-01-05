package com.example.hardcoredemo.modular.ali.alisend;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Value;

public class MessagrServiceImpl implements MessageService {


    @Value("${ali.sms.accessKeyId}")
    private String accessKeyId;

    @Value("${ali.sms.secret}")
    private String secret;

    @Value("${ali.sms.signName}")
    private String signName;

    @Value("${ali.sms.verifyCode}")
    private String verifyCode;



    @Override
    public SendSmsResponse sendVerifySms(CodeVo codeVo) throws ClientException {
        //设置超时时间(不必修改)
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        //(不必修改)
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient，("***"分别填写自己的AccessKey ID和Secret)
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, secret);
        //(不必修改)
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
        //(不必修改)
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象(不必修改)
        SendSmsRequest request = new SendSmsRequest();
        //****处填写接收方的手机号码
        request.setPhoneNumbers(codeVo.getPhoneNumber());
        //****填写已申请的短信签名
        request.setSignName(signName);
        //****填写获得的短信模版CODE
        request.setTemplateCode(verifyCode);
        //反射拿属性名称
        //这里除手机号除外，其余字段有几个添加几个参数，自行添加（根据自定义的模板code来添加）
        String[] filedName = Cutils.getFiledName(codeVo);
        //相关参数
        request.setTemplateParam("{\""+filedName[1]+"\":\""+codeVo.getTestCode1()+"\"}");
        //不必修改
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        return sendSmsResponse;
    }
}