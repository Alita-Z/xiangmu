package com.example.hardcoredemo.modular.tx.wxapplets;

public interface Service {

    /**
     * 获取微信access_token
     * @return
     */
    String getAccessToken();

    /**
     * 根据code获取openid、session_key
     * @param code 小程序传入的code
     * @return WXUserInfo
     */
    WXUserInfo getByCode(String code);
}
