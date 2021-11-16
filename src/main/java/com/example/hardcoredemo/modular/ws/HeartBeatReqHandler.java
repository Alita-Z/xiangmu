package com.example.hardcoredemo.modular.ws;

import com.example.hardcoredemo.model.BdStaff;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class HeartBeatReqHandler extends ChannelDuplexHandler {

    /**
     * @see io.netty.channel.ChannelInboundHandlerAdapter#userEventTriggered(io.netty.channel.ChannelHandlerContext,java.lang.Object)
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
            throws Exception {
        if (IdleStateEvent.class.isAssignableFrom(evt.getClass())) {
            IdleStateEvent event = (IdleStateEvent)evt;
            if (event.state() == IdleState.READER_IDLE) {
                System.out.println("Read   空闲");
                ctx.disconnect();
            }
            else if (event.state() == IdleState.WRITER_IDLE) {
                System.out.println("Write  空闲");
                BdStaff msg = new BdStaff();
                msg.setId("1");
                ctx.writeAndFlush(msg);
            }
        }
    }

}
