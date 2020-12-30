package com.example.hardcoredemo.modular.tx.wxapplets;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.hardcoredemo.common.http.OkHttp3Util;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServeiceImpl implements Service{

    @Value("${weixin.appid}")
    private String appid;

    @Value("${weixin.secret}")
    private String secret;

    @Override
    public String getAccessToken(){
        String message = OkHttp3Util.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret);
        return JSONObject.parseObject(message).get("access_token").toString();
    }

    @Override
    public WXUserInfo getByCode(String code) {
        String message = OkHttp3Util.get("https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code");
        return JSON.parseObject(message, WXUserInfo.class);
    }


}
