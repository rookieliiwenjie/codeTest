package com.company.javaEigt.JavaEightDemo.chapterTwo;

import com.company.javaEigt.JavaEightDemo.domain.Apple;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/10 1:14 上午
 * @Description:
 */
public class AppleColorPredicate implements ApplePredicate{
    @Override
    public boolean compare(Apple apple) {
        return "red".equals(apple.getColor());
    }
}
