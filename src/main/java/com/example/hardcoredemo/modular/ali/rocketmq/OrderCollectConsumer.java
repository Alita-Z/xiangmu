package com.example.hardcoredemo.modular.ali.rocketmq;

import com.example.hardcoredemo.common.protobuf.PlaceOrderProcess;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderCollectConsumer implements MessageListenerOrderly {

    @Override
    public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
        for (MessageExt messageExt : list) {
            PlaceOrderProcess.PlaceOrderMessage placeOrderMessage = null;
            try {
                placeOrderMessage = PlaceOrderProcess.PlaceOrderMessage.parseFrom(messageExt.getBody());
            } catch (InvalidProtocolBufferException e) {
                log.info("consumeMessage placeOrderMessage exception !");
                e.printStackTrace();
//                return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
            }
            if(placeOrderMessage == null){continue;}
            //业务逻辑
            placeOrderMessage.getBody();
        }
        return ConsumeOrderlyStatus.SUCCESS;
    }

}
