package com.company.javaEigt.JavaEightDemo.chapterTwo;

import com.company.javaEigt.JavaEightDemo.domain.Apple;

import java.util.Comparator;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/11 12:44 上午
 * @Description:
 */
public class CompareAppleDemo {
    public static void main(String[] args) {
        List<Apple> appleList = Apple.getAppleList();
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
                //return o1.getWeight() > o2.getWeight() ? 1 : 0;
            }
        });
        System.out.println("appleList = " + appleList);
        appleList.sort((Apple a1, Apple a2) -> a2.getWeight().compareTo(a1.getWeight()));
        System.out.println("appleList = " + appleList);
        appleList.sort(Comparator.comparing(Apple::getWeight));
        System.out.println("appleList = " + appleList);
        appleList.sort(Comparator.reverseOrder());
        System.out.println("appleList = " + appleList);
    }
}
