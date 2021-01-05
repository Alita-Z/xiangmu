package com.example.hardcoredemo.modular.ali.alisend;

import java.lang.reflect.Field;

/**
 * 取类名工具类
 */
public class Cutils {
    public static String[] getFiledName(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNamStrings = new String[fields.length];
        for (int i = 0; i < fieldNamStrings.length; i++) {
            fieldNamStrings[i] = fields[i].getName();

        }
        return fieldNamStrings;
    }

}
