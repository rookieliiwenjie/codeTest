package com.company.javaEigt.JavaEightDemo.chapterTwo;

import com.company.javaEigt.JavaEightDemo.domain.Apple;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/10 1:13 上午
 * @Description:
 */
public interface ApplePredicate {
    /**
     * 比较
     *
     * @param apple 苹果
     * @return boolean
     */
    boolean compare(Apple apple);
}
