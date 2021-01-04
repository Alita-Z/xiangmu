package com.example.hardcoredemo.modular.ali.alisend;



import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

public interface MessageService {

    /**
     * 发送验证码
     * @param phoneNumber
     * @param code
     * @return
     * @throws ClientException
     */
    SendSmsResponse sendVerifySms(String phoneNumber, String code) throws ClientException;
    

}
