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
        String print = printApple(new ApplePrintAllFormatter(), apples);
        System.out.println(print);
        List<Apple> apples2 = filterApple(new ApplePredicate() {
            @Override
            public boolean compare(Apple apple) {
                return "red".equals(apple.getColor());
            }
        }, apples);
        System.out.println("apples2 = " + apples2);



        //Runnable demo java eight
        Thread thread = new Thread(()->{
            System.out.println("runa");
        });
        thread.start();
        System.out.println("thread = " + thread.getName());
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


    public static String printApple(AppleFormatter appleFormatter, List<Apple> apples) {
        StringBuilder desc = new StringBuilder();
        for (Apple apple : apples) {
            desc.append(appleFormatter.print(apple)).append("\n");
        }
        return desc.toString();
    }
}
