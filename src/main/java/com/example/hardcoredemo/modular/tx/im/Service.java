package com.example.hardcoredemo.modular.tx.im;

import java.net.HttpURLConnection;

public interface Service {

    /**
     * 获取http连接
     * @param url 传过来具体的URL
     * @return
     */
    HttpURLConnection getConnection(String url,String length);

    /**
     * 创建群组
     * @param groupId 群组自定义ID
     * @param groupName 群组名称

     */
    void creatGroup(String groupId,String groupName,String userId);

    /**
     * 增加群成员
     * @param groupId 群id
     * @param memberList 群成员数组
     */
    void addGroupMembers(String groupId, String memberList);

    /**
     * 踢出群成员
     * @param groupId 群id
     * @param memberToDelAccount 群成员
     */
    void deleteGroupMembers(String groupId,String memberToDelAccount);

    /**
     * 导入单个账号
     * @param identifier 用户名（id）
     * @param nick 昵称（手机号）
     * @param faceUrl 头像链接（头像URL）
     * @return
     */
    void importOneAccount(String identifier,String nick,String faceUrl);
}
