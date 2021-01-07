package com.example.hardcoredemo.modular.tx.wxapplets;

import java.util.List;
import java.util.Map;

public interface AppletsService {

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

    /**
     * 动态获取微信小程序码
     * @param scene 小程序码携带的参数（最大长度32位）
     * @return 图片流的byte数组
     */
    byte[] getRQCode(String scene);

    /**
     * 消息推送
     * openid 用户的微信openid
     * map 拼接的模板数据
     */
    void publishMessage(String openid, Map<String, Object> map, MessageType type);
    void publishMessagePlus(List<String> openids, Map<String, Object> map, MessageType type);

    /**
     * 解密微信用户信息
     * @param encryptedData 小程序入参
     * @param iv 小程序入参
     * @param sessionKey 必须为微信获取用户信息时的sessionKey，否则解密失败
     * @return
     */
    DecryptData decryptData(String encryptedData, String iv, String sessionKey);
}
