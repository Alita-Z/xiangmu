package com.example.hardcoredemo.modular.ws;

import com.example.hardcoredemo.model.BdStaff;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class HeartBeatRespHandler extends SimpleChannelInboundHandler<BdStaff> {

    /**
     * @see io.netty.channel.SimpleChannelInboundHandler#channelRead0(io.netty.channel.ChannelHandlerContext,
     *      java.lang.Object)
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BdStaff msg) throws Exception {
        if (msg != null) {
            BdStaff user = new BdStaff();
            ctx.writeAndFlush(user);
        }
        else {
            ctx.fireChannelRead(msg);
        }
    }

    /**
     * @see io.netty.channel.ChannelInboundHandlerAdapter#userEventTriggered(io.netty.channel.ChannelHandlerContext,
     *      java.lang.Object)
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
            throws Exception {
        if (IdleStateEvent.class.isAssignableFrom(evt.getClass())) {
            IdleStateEvent event = (IdleStateEvent)evt;
            if (event.state() == IdleState.READER_IDLE) {
                System.out.println("read 空闲 关闭链接");
                ctx.disconnect();
            }
        }
    }

    /**
     * 自定义连接策略
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {


    }

    /**
     * 自定义销毁策略
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

    }

}
