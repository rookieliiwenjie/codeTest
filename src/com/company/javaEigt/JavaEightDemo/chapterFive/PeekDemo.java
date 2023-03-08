package com.company.javaEigt.JavaEightDemo.chapterFive;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/7 2:33 下午
 * @Description: peek 为中间操作，需要配合终止
 */
public class PeekDemo {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        long a = integers.stream().peek(System.out::println).count();
        System.out.println("a = " + a);

    }
}
