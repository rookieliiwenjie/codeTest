package com.company.javaEigt.JavaEightDemo.chapterTwo;

import com.company.javaEigt.JavaEightDemo.domain.Apple;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/10 1:27 上午
 * @Description:
 */
public interface AppleFormatter {
    /**
     * 打印
     *
     * @param apple 苹果
     * @return {@link String}
     */
    String print(Apple apple);
}
