package com.example.hardcoredemo.modular.drools;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private RuleService ruleService;

    @GetMapping("/saveOrder")
    public Order saveOrder() {
        Order order = new Order();
        order.setAmout(1000);
        System.out.println("hello,world");
        return ruleService.executeOrderRule(order);
    }

    @GetMapping("/findplan1")
    public void findplan1() {
        ruleService.executeRoadRule();
    }

    @GetMapping("/findplan2")
    public void findplan2() {
        System.out.println("hello,findplan2");
//        for(;;){
            ruleService.executePlanRule();
//        }
    }

}
