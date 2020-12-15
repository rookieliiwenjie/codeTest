package com.company.javaEigt.Default;

/**
 * @Author rookie.li
 * @create 2020/12/8
 */
public interface Defalut {
    int add(int i);

    default double sqrt(int i) {
        return Math.sqrt(i);
    }
}
