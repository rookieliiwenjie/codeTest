package com.company.javaEigt.JavaEightDemo.chapterTwo;


import com.company.javaEigt.JavaEightDemo.domain.Apple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/10 1:15 上午
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
//        List<Apple> apples = new ArrayList<>();
//        Apple apple = new Apple();
//        apple.setColor("green");
//        apple.setWeight(160);
//        apples.add(apple);
//        Apple apple2 = new Apple();
//        apple2.setColor("black");
//        apple2.setWeight(160);
//        apples.add(apple2);
//
////        List<Apple> apples1 = filterApple(new AppleWeightPredicate(), apples);
////        System.out.println("apples1 = " + apples1);
////        String print = printApple(new ApplePrintAllFormatter(), apples);
////        System.out.println(print);
////        List<Apple> apples2 = filterApple(new ApplePredicate() {
////            @Override
////            public boolean compare(Apple apple) {
////                return "red".equals(apple.getColor());
////            }
////        }, apples);
////        System.out.println("apples2 = " + apples2);
////
////
////
////        //Runnable demo java eight
////        Thread thread = new Thread(()->{
////            System.out.println("runa");
////        });
////        thread.start();
//        //System.out.println("thread = " + thread.getName());
//        Stream<Apple> stream = apples.stream();
//        stream.forEach(System.out::println);
//        //和迭代器类似，流只能遍历一次
//        stream.forEach(System.out::println);
//        System.out.println("args = " + args);
//        HashSet<Long> reduceKeyList = new HashSet<>();
//        reduceKeyList.add(1L);
//        reduceKeyList.add(2L);
//        reduceKeyList.add(3L);
//        reduceKeyList.add(1L);
//        if (!reduceKeyList.isEmpty()) {
//            Long next = reduceKeyList.iterator().next();
//            System.out.println("next = " + next);
//        }
//        long overWeightCount = (long) Math
//                .ceil((2100 - 1000) / 1000.00);
//        System.out.println("overWeightCount = " + overWeightCount);
//        System.out.println("reduceKeyList = " + reduceKeyList);
        double a = 3.2;
        long b = (long) a;
        System.out.println("b = " + b);
        
    
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
