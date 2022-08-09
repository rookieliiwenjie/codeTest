package com.company.javaEigt.JavaEightDemo.chapterTwo;

import com.company.javaEigt.JavaEightDemo.domain.Apple;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/10 1:28 上午
 * @Description:
 */
public class ApplePrintWeightFormatter implements AppleFormatter {
    @Override
    public String print(Apple apple) {

        return "An apple weight is" + apple.getWeight() + "g" + "   ";
    }
}
