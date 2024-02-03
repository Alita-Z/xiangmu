package com.example.hardcoredemo.modular.spel;


import lombok.SneakyThrows;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class spelTest {


    @SneakyThrows
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
//        Expression expression = parser.parseExpression("new java.io.File(\"/app/logs/ucf-ustock-monitor.log\").delete()");
        Process process = Runtime.getRuntime().exec("cmd /c mvn -v"); // 运行dir命令
// 获取进程的输入流 流的方向为(唤醒的进程 -> java程序)
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
        String line;
// 若读取当前行不为空，就将其输出
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
// 将流关闭，避免浪费系统资源
        reader.close();

//        Expression expression = parser.parseExpression("T(Runtime).getRuntime().exec(\"cmd /c mvn -v\")");
//        EvaluationContext context = new StandardEvaluationContext();
//        context.setVariable("new1","123");
//        System.out.println(expression.getValue(context));
    }

}
