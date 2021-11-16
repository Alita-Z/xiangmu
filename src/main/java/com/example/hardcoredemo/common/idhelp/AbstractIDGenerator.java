package com.example.hardcoredemo.common.idhelp;

import com.example.hardcoredemo.common.idhelp.IDGenerator;

/**
 * id生成器抽象实现类
 */
public abstract class AbstractIDGenerator implements IDGenerator {

    @Override
    public Long[] nextIds(int count) {
        Long[] ids = new Long[count];
        int i = 0;
        while(i < count){
            ids[i] = nextId();
            i++;
        }
        return ids;
    }
}

