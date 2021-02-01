package com.example.hardcoredemo.modular.ws;

import com.alibaba.fastjson.JSON;
import com.example.hardcoredemo.model.LzUser;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class RpcEncoder extends MessageToByteEncoder {

    private Class<?> genericClass;

    public RpcEncoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    public void encode(ChannelHandlerContext ctx, Object in, ByteBuf out)
            throws Exception {
        if (genericClass.isInstance(in)) {
            System.out.println("发送的请求是：" + in);
            LzUser user = (LzUser)in;
            String userString = JSON.toJSONString(user);
            System.out.println(JSON.toJSONString(user));
            byte[] data = userString.getBytes();
            out.writeInt(data.length);
            out.writeBytes(data);
        }
    }
}
