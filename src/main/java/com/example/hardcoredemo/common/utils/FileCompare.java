package com.example.hardcoredemo.common.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileCompare {

    public static String fileName1 = "C:\\Users\\Administrator\\Desktop\\demo1.txt";
    public static String fileName2 = "C:\\Users\\Administrator\\Desktop\\demo2.txt";

    public static void main(String[] args) throws Exception {
        List<String> f1 = Files.lines(Paths.get(fileName1)).collect(Collectors.toList());
        List<String> f2 = Files.lines(Paths.get(fileName2)).collect(Collectors.toList());
        for (String s : f2){
            if(!f1.contains(s)){
                System.out.println(s);
            }
        }
    }
}
