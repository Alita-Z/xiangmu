package com.example.hardcoredemo.modular.tx.im;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.hardcoredemo.modular.tx.im.config.TLSSigAPIv2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Slf4j
public class ImServiceImpl implements Service{



    /**
     * 应用唯一标识
     */
    @Value("${im.sdkAppId}")
    private long sdkAppId;

    /**
     * 权限票据
     */
    @Value("${im.secretKey}")
    private String secretKey;

    /**
     * 用户id
     */
    @Value("${im.userId}")
    private String userId;

    /**
     * 签名超时时间
     */
    @Value("${im.expire}")
    private long expire;

    /**
     * 创建群组的请求地址
     */
    private static final String creatGroupUrl = "https://console.tim.qq.com/v4/group_open_http_svc/create_group?sdkappid=";

    /**
     * 增加群成员的请求地址
     */
    private static final String addGroupMembersUrl = "https://console.tim.qq.com/v4/im_open_login_svc/account_import?sdkappid=";

    /**
     * 删除群成员的请求地址
     */
    private static final String deleteGroupMembersUrl = "https://console.tim.qq.com/v4/group_open_http_svc/delete_group_member?sdkappid=";

    /**
     * 导入一个群成员的请求地址
     */
    private static final String importOneAccountUrl = "https://console.tim.qq.com/v4/im_open_login_svc/account_import?sdkappid=";


    /**
     * 获取http连接
     * @param url 传过来具体的URL
     * @return
     */
    @Override
    public HttpURLConnection getConnection(String url,String length){
        HttpURLConnection connection = null;
        try {
            Random r = new Random();
            int random = r.nextInt(1000000000) + 1;
            //获取App管理员帐号生成的签名
            String usersig = TLSSigAPIv2.genUserSig(userId, expire, sdkAppId, secretKey);
            URL conUrl = new URL(url+ sdkAppId + "&identifier=" + userId + "&usersig=" + usersig + "&random=" + random + "&contenttype=json");
            //通过远程url连接对象打开连接
            connection = (HttpURLConnection) conUrl.openConnection();
            // 设置连接请求方式
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length","");
            // 设置连接主机服务器超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            connection.setReadTimeout(60000);
            connection.setDoOutput(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void creatGroup(String groupId, String groupName,String userId) {
        //获取App管理员帐号生成的签名
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        Map<String, Object> map = new HashMap<>();
        //群主id
        map.put("Owner_Account", userId);
        //群组类型
        map.put("Type", "Public");
        //群组id
        map.put("GroupId", groupId);
        //群组名称
        map.put("Name", groupName);
        String s = JSON.toJSONString(map);
        log.info("发送的建群参数:{}", s);
        try {
            byte[] postDataBytes = JSON.toJSONString(map).getBytes("UTF-8");
            connection = getConnection(creatGroupUrl, String.valueOf(postDataBytes.length));
            connection.connect();
            OutputStream out = connection.getOutputStream();
            out.write(postDataBytes);
            out.flush();
            out.close();
            //返回值
            int statusCode = connection.getResponseCode();
            if (HttpServletResponse.SC_OK == statusCode) {
                //获取返回的字符
                inputStream = connection.getInputStream();
                int size = inputStream.available();
                byte[] bs = new byte[size];
                inputStream.read(bs);
                String message = new String(bs, "UTF-8");
                JSONObject groupInfo = JSONObject.parseObject(message);
                log.info("请求返回:{}",groupInfo.toJSONString());
                String actionStatus = groupInfo.getString("ActionStatus");
                if ("OK".equals(actionStatus)) {
                    System.out.println(groupInfo);
                }
            }
            connection.disconnect();
        } catch (IOException e) {
            log.error("创建群组错误，{}",e.getMessage());
            try {
                inputStream.close();
            } catch (IOException e1) {
                log.error("创建群组错误，{}",e.getMessage());
            }
            connection.disconnect();
        }
        return;
    }

    @Override
    @Async
    public void addGroupMembers(String groupId, String memberAccount) {
        //获取App管理员帐号生成的签名
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        Map<String, Object> map = new HashMap<>();
        //群组id
        map.put("GroupId", groupId);
        Map<String, Object> groupMap = new HashMap<>();
        //群成员
        groupMap.put("Member_Account", memberAccount);
        List<Map> list = new ArrayList<>();
        list.add(groupMap);
        map.put("MemberList", list);
        String s = JSON.toJSONString(map);
        log.info("发送的增加群成员参数:{}", s);
        try {
            byte[] postDataBytes = JSON.toJSONString(map).getBytes("UTF-8");
            connection = getConnection(addGroupMembersUrl, String.valueOf(postDataBytes.length));
            connection.connect();
            OutputStream out = connection.getOutputStream();
            out.write(postDataBytes);
            out.flush();
            out.close();
            //返回值
            int statusCode = connection.getResponseCode();
            if (HttpServletResponse.SC_OK == statusCode) {
                //获取返回的字符
                inputStream = connection.getInputStream();
                int size = inputStream.available();
                byte[] bs = new byte[size];
                inputStream.read(bs);
                String message = new String(bs, "UTF-8");
                JSONObject groupInfo = JSONObject.parseObject(message);
                log.info("请求返回:{}",groupInfo.toJSONString());
                String actionStatus = groupInfo.getString("ActionStatus");
                if ("OK".equals(actionStatus)) {
                    System.out.println(groupInfo);
                }
            }
            connection.disconnect();
        } catch (IOException e) {
            log.error("增加群成员错误，{}",e.getMessage());
            try {
                inputStream.close();
            } catch (IOException e1) {
                log.error("增加群成员错误，{}",e.getMessage());
            }
            connection.disconnect();
        }
        return;

    }

    @Override
    @Async
    public void deleteGroupMembers(String groupId, String memberToDelAccount) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        Map<String, Object> map = new HashMap<>();
        //群组id
        map.put("GroupId", groupId);
        List<String> list = new ArrayList();
        list.add(memberToDelAccount);
        //群组成员id
        map.put("MemberToDel_Account", list);
        String s = JSON.toJSONString(map);
        log.info("发送的删除群成员参数:{}", s);
        try {
            byte[] postDataBytes = JSON.toJSONString(map).getBytes("UTF-8");
            //获取HTTP连接
            connection = getConnection(deleteGroupMembersUrl, String.valueOf(postDataBytes.length));
            connection.connect();
            OutputStream out = connection.getOutputStream();
            out.write(postDataBytes);
            out.flush();
            out.close();
            //返回值
            int statusCode = connection.getResponseCode();
            if (HttpServletResponse.SC_OK == statusCode) {
                //获取返回的字符
                inputStream = connection.getInputStream();
                int size = inputStream.available();
                byte[] bs = new byte[size];
                inputStream.read(bs);
                String message = new String(bs, "UTF-8");
                JSONObject groupInfo = JSONObject.parseObject(message);
                log.info("请求返回:{}",groupInfo.toJSONString());
                String actionStatus = groupInfo.getString("ActionStatus");
                if ("OK".equals(actionStatus)) {
                    System.out.println(groupInfo);
                }
            }
            connection.disconnect();
        } catch (IOException e) {
            log.error("删除群成员错误，{}",e.getMessage());
            try {
                inputStream.close();
            } catch (IOException e1) {
                log.error("删除群成员错误，{}",e.getMessage());
            }
            connection.disconnect();
        }
        return;
    }

    @Override
    @Async
    public void importOneAccount(String identifier, String nick, String faceUrl) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        Map<String, Object> map = new HashMap<>();
        //群组id
        map.put("Identifier", identifier);
        map.put("Nick", nick);
        map.put("FaceUrl", faceUrl);
        try {
            byte[] postDataBytes = JSON.toJSONString(map).getBytes("UTF-8");
            //获取HTTP连接
            connection = getConnection(importOneAccountUrl, String.valueOf(postDataBytes.length));
            connection.connect();
            OutputStream out = connection.getOutputStream();
            out.write(postDataBytes);
            out.flush();
            out.close();
            //返回值
            int statusCode = connection.getResponseCode();
            System.out.println(statusCode);
            if (HttpServletResponse.SC_OK == statusCode) {
                //获取返回的字符
                inputStream = connection.getInputStream();
                int size = inputStream.available();
                byte[] bs = new byte[size];
                inputStream.read(bs);
                String message = new String(bs, "UTF-8");
                JSONObject groupInfo = JSONObject.parseObject(message);
                log.info("请求返回:{}",groupInfo.toJSONString());
                String actionStatus = groupInfo.getString("ActionStatus");
                if ("OK".equals(actionStatus)) {
                    System.out.println(groupInfo);
                }
            }
            connection.disconnect();
        } catch (IOException e) {
            log.error("导入单个成员错误，{}",e.getMessage());
            try {
                inputStream.close();
            } catch (IOException e1) {
                log.error("导入单个成员错误，{}",e.getMessage());
            }
            connection.disconnect();
        }
        return;
    }

}
