package com.example.hardcoredemo;

import com.example.hardcoredemo.modular.disruptor.SeriesData;
import com.example.hardcoredemo.modular.disruptor.SeriesDataEventQueueHelper;
import com.example.hardcoredemo.modular.tx.wxapplets.MessageType;
import com.example.hardcoredemo.modular.tx.wxapplets.AppletsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@SpringBootTest(classes = HardCoreDemoApplication.class)
@RunWith(SpringRunner.class)
@ContextConfiguration
class HardCoreDemoApplicationTests {

    @Autowired
    AppletsService service;

    @Autowired
    private SeriesDataEventQueueHelper seriesDataEventQueueHelper;

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        /**
         * 微信消息推送
         */
//        service.publishMessage("", MessageType.formatPAY("","",""), MessageType.PAY);
//        service.publishMessagePlus(new ArrayList<>(), MessageType.formatPAY("","",""), MessageType.PAY);
        /**
         * disruptor
         */
//        seriesDataEventQueueHelper.publishEvent(new SeriesData("111"));
    }
}
