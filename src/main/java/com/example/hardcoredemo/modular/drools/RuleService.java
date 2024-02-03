package com.example.hardcoredemo.modular.drools;

import com.alipay.api.domain.Person;
import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import org.checkerframework.checker.units.qual.C;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.drools.ruleunit.impl.RuleUnitKnowledgeHelper;
import org.kie.api.KieBase;
import org.kie.api.cdi.KBase;
import org.kie.api.cdi.KContainer;
import org.kie.api.command.Command;
import org.kie.api.event.process.ProcessEventListener;
import org.kie.api.event.rule.*;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.api.runtime.rule.RuleFlowGroup;
import org.kie.internal.command.CommandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class RuleService {
    @Autowired
    private KieBase kieBase;
//    @Autowired
//    private KieContainer kieContainer;
//    @KBase
//    private KieBase kbase;
//    @KContainer
//    private KieContainer kContainer;

    /*** 执⾏订单⾦额积分规则 */
    public Order executeOrderRule(Order order) {
        //无状态
//        StatelessKieSession lessKieSession = kieBase.newStatelessKieSession();
//        lessKieSession.execute(order);
//        List<Command> list = new ArrayList<>();
//        list.add(CommandFactory.newInsert(order));
//        ExecutionResults results =
//                lessKieSession.execute( CommandFactory.newBatchExecution(Lists.newArrayList(list)));
        //有状态
        KieSession kieSession = kieBase.newKieSession();
//        kieSession.setGlobal("test", kieBase);
//        kieSession.getAgenda().getAgendaGroup("test-rule").setFocus();
        kieSession.addEventListener(new RuleRuntimeEventListener() {
            public void objectInserted(ObjectInsertedEvent event) {
                System.out.println("Object inserted \n"
                        + event.getObject().toString());
            }
            public void objectUpdated(ObjectUpdatedEvent event) {
                System.out.println("Object was updated \n"
                        + "new Content \n" + event.getObject().toString());
            }
            public void objectDeleted(ObjectDeletedEvent event) {
                System.out.println("Object retracted \n"
                        + event.getOldObject().toString());
            }
        });
        kieSession.addEventListener(new AgendaEventListener() {
            public void matchCreated(MatchCreatedEvent event) {
                System.out.println("The rule "
                        + event.getMatch().getRule().getName()
                        + " can be fired in agenda");
            }
            public void matchCancelled(MatchCancelledEvent event) {
                System.out.println("The rule "
                        + event.getMatch().getRule().getName()
                        + " cannot b in agenda");
            }
            public void beforeMatchFired(BeforeMatchFiredEvent event) {
                System.out.println("The rule "
                        + event.getMatch().getRule().getName()
                        + " will be fired");
            }
            public void afterMatchFired(AfterMatchFiredEvent event) {
                System.out.println("The rule "
                        + event.getMatch().getRule().getName()
                        + " has be fired");
            }
            public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
            }
            public void agendaGroupPushed(AgendaGroupPushedEvent event) {
            }
            public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
            }
            public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
            }
            public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
            }
            public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
            }
        });
//        for(int i = 0; i < 999999999; i++){
//            for(int j = 0; j < 50; j++){
//                Order order1 = new Order();
//                order1.setAmout(1000);
//                //要执行rule的实体
//                kieSession.insert(order1);
//            }
//            //查询rule
//            kieSession.fireAllRules();
//            System.out.println("?");
//        }
        //要执行rule的实体
        kieSession.insert(order);
        //查询rule
        kieSession.fireAllRules();
        //关闭会话
        kieSession.dispose();
        return order;
    }

    @SneakyThrows
    public void executePlanRule() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2018-09-30");
        Date date2 = sdf.parse("2018-09-31");
        KieSession kieSession = kieBase.newKieSession();
        Segment seg = new Segment();
        seg.setArriveCity("PEK");
        seg.setStartCity("XMN");
        seg.setFlightDate(date1);
        seg.setCabin("Y");
        seg.setProCode("seg1");
        Segment seg2 = new Segment();
        seg2.setArriveCity("PEK");
        seg2.setStartCity("XMN");
        seg2.setFlightDate(date1);
        seg2.setCabin("T");
        seg2.setProCode("seg2");
        Segment seg3 = new Segment();
        seg3.setArriveCity("XMN");
        seg3.setStartCity("TSN");
        seg3.setFlightDate(date1);
        seg3.setCabin("Y");
        seg3.setProCode("seg3");
        Hotel hotel = new Hotel();
        hotel.setCheckInDate(date1);
        hotel.setIfCanPackageSale(true);
        hotel.setLocation(new Location("", "", "XMN"));
        hotel.setProCode("hotel1");
        Hotel hotel2 = new Hotel();
        hotel2.setCheckInDate(date2);
        hotel2.setIfCanPackageSale(true);
        hotel2.setLocation(new Location("", "", "XMN"));
        hotel2.setProCode("hotel2");
        Hotel hotel3 = new Hotel();
        hotel3.setCheckInDate(date1);
        hotel3.setIfCanPackageSale(true);
        hotel3.setLocation(new Location("", "", "NRT"));
        hotel3.setProCode("hotel3");
        Hotel hotel4 = new Hotel();
        hotel4.setCheckInDate(date1);
        hotel4.setIfCanPackageSale(true);
        hotel4.setLocation(new Location("", "", "PEK"));
        hotel4.setProCode("hotel4");

        ReservedLounge lounge = new ReservedLounge();
        lounge.setLocation(new Location("", "", "XMN"));
        lounge.setSelfSupport(true);
        lounge.setProCode("lounge1");
        ReservedLounge lounge2 = new ReservedLounge();
        lounge2.setLocation(new Location("", "", "PEK"));
        lounge2.setSelfSupport(true);
        lounge2.setProCode("lounge2");
        ReservedLounge lounge3 = new ReservedLounge();
        lounge3.setLocation(new Location("", "", "XMN"));
        lounge3.setSelfSupport(false);
        lounge3.setProCode("lounge3");
        kieSession.insert(seg);
        kieSession.insert(seg2);
        kieSession.insert(seg3);
        kieSession.insert(hotel);
        kieSession.insert(hotel2);
        kieSession.insert(hotel3);
        kieSession.insert(hotel4);
        kieSession.insert(lounge);
        kieSession.insert(lounge2);
        kieSession.insert(lounge3);
        //查询rule
        kieSession.fireAllRules();
//        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("rule_filter_1"));
//        QueryResults queryResults = kieSession.getQueryResults("query-1");
//        for(QueryResultsRow row : queryResults){
//            Hotel hotels = (Hotel) row.get("$hotel");
//            System.out.println("Person from WM, age : " + hotels.getLocation());
//        }
//        QuartzHelper
        //关闭会话
        kieSession.dispose();
    }

    @SneakyThrows
    public Car executeRoadRule() {
        KieSession kieSession = kieBase.newKieSession();

        Car car1 = new Car();
        car1.setBegin("A");
        car1.setEnds("D");
        Road road1 = new Road();
        road1.setBegin("A");
        road1.setEnds("B");
        Road road2 = new Road();
        road2.setBegin("A");
        road2.setEnds("C");
        Road road3 = new Road();
        road3.setBegin("B");
        road3.setEnds("D");
        Road road4 = new Road();
        road4.setBegin("C");
        road4.setEnds("D");
        kieSession.insert(car1);
        kieSession.insert(road1);
        kieSession.insert(road2);
        kieSession.insert(road3);
        kieSession.insert(road4);
        //查询rule
        kieSession.fireAllRules();
//        kieSession.fireAllRules(new RuleNameEqualsAgendaFilter("rule_filter_1"));

        //关闭会话
        kieSession.dispose();
        return car1;
    }

}
