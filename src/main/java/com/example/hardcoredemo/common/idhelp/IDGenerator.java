package com.example.hardcoredemo.common.idhelp;

import java.io.Serializable;

public interface IDGenerator {
    /**
     * 生成字符型id
     * @return 字符型id
     */
    <T extends Serializable>T nextId();

    /**
     * 生成指定数量字符型id数组
     * @return 字符型id数组
     */
    <T extends Serializable>T[] nextIds(int count);
}