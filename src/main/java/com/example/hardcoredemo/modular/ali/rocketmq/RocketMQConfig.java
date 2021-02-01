package com.example.hardcoredemo.modular.ali.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RocketMQConfig {

    @Value("${apache.rocketmq.producer.namesrvAddr}")
    String nameSrvAddr;

    @Bean
    public DefaultMQPushConsumer initPushConsumer() throws MQClientException {
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer();
        defaultMQPushConsumer.setConsumerGroup("CID_EXCHANGE_ENTRUST_ORDER");
        defaultMQPushConsumer.setNamesrvAddr(nameSrvAddr);
        defaultMQPushConsumer.subscribe("EXCHANGE_ENTRUST_ORDER_TOPIC", "*");
        defaultMQPushConsumer.registerMessageListener(new OrderCollectConsumer());
        defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //单次拉取消息条数(0~1024)
        defaultMQPushConsumer.setConsumeMessageBatchMaxSize(1);
        //设置消费线程数大小取值范围(0~1000)
        defaultMQPushConsumer.setConsumeThreadMin(20);
        defaultMQPushConsumer.setConsumeThreadMax(20);
        try {
            defaultMQPushConsumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return defaultMQPushConsumer;
    }
}