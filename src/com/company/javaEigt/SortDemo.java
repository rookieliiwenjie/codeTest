package com.company.javaEigt;

import java.util.*;

/**
 * @Author rookie.li
 * @create 2020/12/8
 */
public class SortDemo {
    public static void main(String[] args) {
        demo1();
    }

    private static void demo1() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(3);
        integerList.add(2);
        Collections.sort(integerList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        Collections.sort(integerList, (o1, o2) -> o1.compareTo(o2));
        System.out.println("integerList = " + integerList);
    }

    private static void demo2() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(3);
        integerList.add(2);
        Collections.sort(integerList, Comparator.reverseOrder());
        System.out.println("integerList = " + integerList);
    }
}
