package com.example.hardcoredemo.modular.drools;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Order {
    private Integer amout;
    private Integer score;

    Order(){
        System.out.println("123");
    }
}

