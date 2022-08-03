package com.company.javaEigt.JavaEightDemo.chapterOne;

import com.company.javaEigt.JavaEightDemo.domain.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/3 11:59 下午
 * @Description:
 */
public class AppleDemo {
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
        System.out.println("apples1.toString() = " + apples.toString());
        List<Apple> apples1 = filterApples(apples, AppleDemo::isGreenApple);
        System.out.println("apples1.toString() = " + apples1.toString());
        //匿名函数写法
        List<Apple> apples2 = filterApples(apples, (Apple a) -> a.getColor().equals("green"));
        List<Apple> green = apples.stream().filter(apple1 -> apple.getColor().equals("green")).collect(Collectors.toList());
    }

    /**
     * 苹果是绿色
     *
     * @param apple 苹果
     * @return boolean
     */
    static boolean isGreenApple(Apple apple) {
        System.out.println("apple.toString() = " + apple.toString());
        return "green".equals(apple.getColor());
    }

    /**
     * 是否是大于150重苹果
     *
     * @param apple 苹果
     * @return boolean
     */
    static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> apple) {
        List<Apple> filterApple = new ArrayList<>();
        for (Apple apple1 : apples) {
            if (apple.test(apple1)) {
                filterApple.add(apple1);
            }
        }
        return filterApple;
    }
}
