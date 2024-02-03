package com.example.hardcoredemo.common.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MavenTools {

    // mvn 上传指令
    public static final String mvn_commond_format = "mvn deploy:deploy-file -DgroupId=%s -DartifactId=%s -Dversion=%s -Durl=%s -DrepositoryId=weimob -Dfile=%s";
    // mvn 远程仓库地址1
    public static final String release_mvn_url = "https://repo.yyrd.com/artifactory/iUAP-Stagings";
    // mvn 远程仓库地址2
    public static final String snopshot_mvn_url = "https://repo.yyrd.com/artifactory/iUAP-Stagings";

    public static void main(String[] args) throws Exception {
        try {
            // args 参数为jar-info.txt :包含jar信息的文件
            if (args == null || args.length == 0) {
                return;
            }
            System.out.println("read file : " + args[0]);
            // 读取文件
            List<String> commondLines = readFile(args[0]);
            // 调用cmd 指令，循环执行mvn上传指令
            for (String commondLine : commondLines) {
                Runtime.getRuntime().exec("cmd /k start " + commondLine);
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 读取文件
    public static List<String> readFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String[] arrs = null;
        List<String> mvnCmdList = new ArrayList<>();
        // 安装自定义的规则，解析文件; 然后拼接mvn上传的指令，缓存到list中返回
        while ((line = br.readLine()) != null) {
            //com.abc.o2o:abc-security:1.0.1-SNAPSHOT
            arrs = line.split(":");
            if (arrs.length != 3)
                continue;
            String file = arrs[1].concat("-").concat(arrs[2]).concat(".jar");
            if (arrs[2].toLowerCase().contains("release")) {
                mvnCmdList.add(String.format(mvn_commond_format, arrs[0], arrs[1], arrs[2], release_mvn_url,file));
            } else {
                mvnCmdList.add(String.format(mvn_commond_format, arrs[0], arrs[1], arrs[2], snopshot_mvn_url,file));
            }
        }
        br.close();
        fr.close();
        for (String s : mvnCmdList) {
            System.out.println(s);
            System.out.println();
        }
        return mvnCmdList;
    }

//    public static void main(String[] args) {
//
//    }

}
