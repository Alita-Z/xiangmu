package com.example.hardcoredemo.modular.tx.wxapplets;

import lombok.Data;

/**
 * 根据微信code获取的信息类
 */
@Data
public class WXUserInfo {

    /**
     * openid
     */
    private String openid;

    /**
     * session_key
     */
    private String session_key;
}
