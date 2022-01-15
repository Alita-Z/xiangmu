package com.example.hardcoredemo.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {
    private static ApplicationContext context;

    private ApplicationContextProvider() {
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    public static <T> T getBean(String name) throws BeansException {
        return (T) context.getBean(name);
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}