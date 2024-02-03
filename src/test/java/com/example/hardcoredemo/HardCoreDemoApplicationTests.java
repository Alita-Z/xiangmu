package com.example.hardcoredemo;

import com.example.hardcoredemo.modular.disruptor.SeriesData;
import com.example.hardcoredemo.modular.disruptor.SeriesDataEventQueueHelper;
import com.example.hardcoredemo.modular.tx.wxapplets.MessageType;
import com.example.hardcoredemo.modular.tx.wxapplets.AppletsService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import sun.tools.jar.Main;
import weka.classifiers.Evaluation;
import weka.classifiers.misc.InputMappedClassifier;
import weka.core.Instances;

import java.io.FileReader;
import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.invoke.MethodHandles.lookup;

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
        System.out.println(enumss.female);
        RedissonClient redissonClient;
        RLock lock;
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
         *
         */
//        service.publishMessage("", MessageType.formatPAY("","",""), MessageType.PAY);
//        service.publishMessagePlus(new ArrayList<>(), MessageType.formatPAY("","",""), MessageType.PAY);
        /**
         * disruptor
         */
//        seriesDataEventQueueHelper.publishEvent(new SeriesData("111"));
    }

    @SneakyThrows
    public static void main(String[] args) {
        try{

        }catch (Exception e){

        }finally {

        }


        MethodHandles.lookup();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        List<sun> list = new ArrayList();
        list.add(new sun());list.add(new sun());list.add(new sun());list.add(new sun());
        System.out.println(list);
        Iterator<sun> iterator = list.iterator();
        while (iterator.hasNext()) {
            sun appConf = iterator.next();
            iterator.remove();
        }
        System.out.println(list);


        //weka
        InputMappedClassifier clf = new InputMappedClassifier();
        String irisPath = Paths.get(System.getenv("WEKA_HOME"), "packages", "wekaDeeplearning4j", "datasets", "nominal", "iris.arff").toString();
        Instances inst = new Instances(new FileReader(irisPath));
        inst.setClassIndex(inst.numAttributes() - 1);
        Evaluation ev = new Evaluation(inst);
        ev.crossValidateModel(clf, inst, 10, new Random(0));
        System.out.println(ev.toSummaryString());
    }



}
