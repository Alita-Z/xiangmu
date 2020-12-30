package com.example.hardcoredemo.common.http;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;

@Slf4j
@Component
public class OkHttp3Util {

    private static OkHttpClient okHttpClient;

    @Autowired
    public OkHttp3Util(OkHttpClient  okHttpClient) {
        OkHttp3Util.okHttpClient= okHttpClient;
    }

    /**
     * get 参数自拼
     * @param url 请求的url
     * @return 返回的内容字符串
     */
    public static String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return response(request);
    }

    /**
     * get 参数自拼、返回byte、获取流或避开utf-8转码问题用
     * @param url 请求的url
     * @return 返回的内容字符串
     */
    public static byte[] getStream(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return responseStream(request);
    }

    /**
     * get
     * @param url 请求的url
     * @param params 请求的参数，在浏览器？后面的数据，没有可以传null
     * @return 返回的内容字符串
     */
    public static String get(String url, Map<String, String> params) {
        if (params != null && params.keySet().size() > 0) {
            return OkHttp3Util.get(getFormatUrl(url, params));
        }else {
            return OkHttp3Util.get(url);
        }
    }

    /**
     * get
     * @param url 请求的url
     * @param params 请求的参数，在浏览器？后面的数据，没有可以传null
     * @param headers 请求头key-value，没有可以传null
     * @return 返回的内容字符串
     */
    public static String getAndHeader(String url, Map<String, String> params, Map<String, String> headers) {
        if (params != null && params.keySet().size() > 0) {
            url = getFormatUrl(url, params);
        }
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.keySet().size() > 0) {
            Iterator iterator = headers.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry<String, String>) iterator.next();
                builder.addHeader(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        Request request = builder.url(url).build();
        return response(request);
    }

    private static String getFormatUrl(String url, Map<String, String> params){
        StringBuilder sb = new StringBuilder(url);
        boolean firstFlag = true;
        Iterator iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry<String, String>) iterator.next();
            if (firstFlag) {
                sb.append("?").append(entry.getKey()).append("=").append(entry.getValue());
                firstFlag = false;
            } else {
                sb.append("&").append(entry.getKey()).append("=").append(entry.getValue());
            }
        }
        return sb.toString();
    }

    /**
     * post请求
     * @param url 请求的url
     * @param params post form 提交的参数
     * @return 返回的内容字符串
     */
    public static String post(String url, Map<String, String> params) {
        FormBody.Builder builder = new FormBody.Builder();
        //添加参数
        if (params != null && params.keySet().size() > 0) {
            for (String key : params.keySet()) {
                builder.add(key, params.get(key));
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        return response(request);
    }

    /**
     * post请求
     * @param url 路径
     * @param body 请求体
     * @param postType 请求格式类型
     * @return 返回的内容字符串
     */
    public static String post(String url, String body, PostType postType) {
        RequestBody requestBody;
        if(PostType.JSON.code.equals(postType.code)){
            requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body);
        }else if(PostType.XML.code.equals(postType.code)){
            requestBody = RequestBody.create(MediaType.parse("application/xml; charset=utf-8"), body);
        }else {
            throw new RuntimeException("未知类型");
        }
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return response(request);
    }

    /**
     * post请求返回byte、获取流或避开utf-8转码问题用
     * @param url 路径
     * @param body 请求体
     * @param postType 请求格式类型
     * @return 返回的内容字符串
     */
    public static byte[] postStream(String url, String body, PostType postType) {
        RequestBody requestBody;
        if(PostType.JSON.code.equals(postType.code)){
            requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), body);
        }else if(PostType.XML.code.equals(postType.code)){
            requestBody = RequestBody.create(MediaType.parse("application/xml; charset=utf-8"), body);
        }else {
            throw new RuntimeException("未知类型");
        }
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return responseStream(request);
    }

    private static String response(Request request){
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
//            int status = response.code();
            if (response.isSuccessful()) {
                return response.body() != null ? response.body().string() : "";
            }
        } catch (Exception e) {
            log.error("okhttp3 response error >> ex = {}", ExceptionUtils.getStackTrace(e));
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return "";
    }

    private static byte[] responseStream(Request request){
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
//            int status = response.code();
            if (response.isSuccessful()) {
                return response.body() != null ? response.body().bytes() : null;
            }
        } catch (Exception e) {
            log.error("okhttp3 response error >> ex = {}", ExceptionUtils.getStackTrace(e));
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return null;
    }

}
