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
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest(classes = HardCoreDemoApplication.class)
@RunWith(SpringRunner.class)
@ContextConfiguration
class HardCoreDemoApplicationTests {

    @Autowired
    AppletsService service;

//    @Autowired
    private SeriesDataEventQueueHelper seriesDataEventQueueHelper;

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
//        List<sun> list = new ArrayList<>();
//        tesst(list);
//        sun.excute();
//        father father = new father();
//        father.excute();
        List<sun> list = new ArrayList();
        list.add(new sun());list.add(new sun());list.add(new sun());list.add(new sun());
        System.out.println(list);
        Iterator<sun> iterator = list.iterator();
        while (iterator.hasNext()) {
            sun appConf = iterator.next();
                iterator.remove();
        }
        System.out.println(list);
//        System.out.println(list.stream().collect(Collectors.toList()));
//        sun sun = new sun();
//        sun.excute();
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

    public static void main(String[] args) {
        List<sun> list = new ArrayList();
        list.add(new sun());list.add(new sun());list.add(new sun());list.add(new sun());
        System.out.println(list);
        Iterator<sun> iterator = list.iterator();
        while (iterator.hasNext()) {
            sun appConf = iterator.next();
            iterator.remove();
        }
        System.out.println(list);
    }

    private void tesst(List<sun> list){
        if(false){

        }else {
            tesstt(list);
        }
    }
    private void tesstt(List<sun> list){
        sun sun = new sun();
        sun.name = "111";
        List<sun> list1 = new ArrayList<>();
        list1.add(sun);
        list.addAll(list1);
        list1.forEach(s -> {
            s.name = "333";
            father father = new father();
            father.name = s.name;
            s.list.add(father);
        });
        list.forEach(ss -> ss.name = "222");
    }
}
