package com.company.javaEigt.JavaEightDemo.chapterTwo;

import com.company.javaEigt.JavaEightDemo.domain.Apple;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/10 1:28 上午
 * @Description:
 */
public class ApplePrintAllFormatter implements AppleFormatter {
    @Override
    public String print(Apple apple) {
        String desc = apple.getWeight() < 150 ? " light " : " heavy ";
        return "A" + desc + apple.getColor() + " apple ";
    }
}
