package com.company.javaEigt.JavaEightDemo.chapterTwo;


import com.company.javaEigt.JavaEightDemo.domain.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/10 1:15 上午
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        Apple apple = new Apple();
        apple.setColor("green");
        apple.setWeight(160);
        apples.add(apple);
        Apple apple2 = new Apple();
        apple2.setColor("black");
        apple2.setWeight(160);
        apples.add(apple2);

        List<Apple> apples1 = filterApple(new AppleWeightPredicate(), apples);
        System.out.println("apples1 = " + apples1);
    }

    public static List<Apple> filterApple(ApplePredicate applePredicate, List<Apple> apples) {
        List<Apple> apples1 = new ArrayList<>();
        for (Apple apple : apples) {
            if (applePredicate.compare(apple)) {
                apples1.add(apple);
            }
        }
        return apples1;
    }
}
