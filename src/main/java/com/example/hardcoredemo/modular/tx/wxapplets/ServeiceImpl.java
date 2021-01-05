package com.example.hardcoredemo.modular.tx.wxapplets;

import com.alibaba.fastjson.JSON;
import com.example.hardcoredemo.common.http.OkHttp3Util;
import com.example.hardcoredemo.common.http.PostType;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ServeiceImpl implements Service{

    @Value("${weixin.appid}")
    private String appid;

    @Value("${weixin.secret}")
    private String secret;

    @Override
    public String getAccessToken(){
        String message = OkHttp3Util.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret);
        return JSON.parseObject(message).get("access_token").toString();
    }

    @Override
    public WXUserInfo getByCode(String code) {
        String message = OkHttp3Util.get("https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code");
        return JSON.parseObject(message, WXUserInfo.class);
    }

    @Override
    public byte[] getRQCode(String scene){
        String accessToken = getAccessToken();
        if(StringUtils.isBlank(accessToken)){return null;}
        Map<String,Object> params = new HashMap<>();
        params.put("scene",scene);
//        params.put("page","pages/index/login");
//        params.put("width","");
//        params.put("auto_color","");
//        params.put("line_color","");
//        params.put("is_hyaline","");
        return OkHttp3Util.postStream("https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + accessToken,
                JSON.toJSONString(params), PostType.JSON);
    }

    @Override
    public DecryptData decryptData(String encryptedData, String iv, String sessionKey){
        // 被加密的数据
        byte[] dataByte = org.bouncycastle.util.encoders.Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = org.bouncycastle.util.encoders.Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSON.parseObject(result, DecryptData.class);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidParameterSpecException
                | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException
                | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchProviderException e) {
            e.printStackTrace();
        }
        return null;
    }
}
