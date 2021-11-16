package com.example.hardcoredemo.modular.ws;

import com.alibaba.fastjson.JSON;
import com.example.hardcoredemo.model.BdStaff;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class RpcDecoder extends ByteToMessageDecoder {

    private Class<?> genericClass;

    public RpcDecoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    public final void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out)
            throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        in.markReaderIndex();
        int dataLength = in.readInt();
        if (dataLength < 0) {
            ctx.close();
        }
        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex();
        }
        byte[] data = new byte[dataLength];
        in.readBytes(data);

        Object obj = JSON.parseObject(new String(data), BdStaff.class);
        System.out.println("接收到的消息是：" + obj);
        out.add(obj);
    }
}
