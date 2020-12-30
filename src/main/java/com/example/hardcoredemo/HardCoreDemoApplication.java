package com.example.hardcoredemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ServletComponentScan
@ComponentScan(basePackages = "com.example.hardcoredemo")
@MapperScan("com.example.hardcoredemo.dao")
@EnableTransactionManagement
@EnableAsync
@EnableScheduling
public class HardCoreDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HardCoreDemoApplication.class, args);
    }

}
