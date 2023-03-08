package com.company.javaEigt.JavaEightDemo.ExecutorsDemo;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/13 10:47 上午
 * @Description:
 */
public class ParallelStreamDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("4");
        list.add("2");
        list.add("5");
        list.add("3");


        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list2.add("5");
        // parallelStream(list);
        // findStream(list);
        // sort();
        concat();

    }


    private static void sort() {
        List<Integer> integerStream = Stream.of(1, 2, 3).collect(Collectors.toList());
        List<Integer> collect = integerStream.stream().sorted().collect(Collectors.toList());
        System.out.println("倒序collect = " + collect);

        List<Integer> sort = integerStream.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("正序collect = " + sort);
    }

    private static void concat() {
//        Stream<Integer> integerStream = Stream.of(1, 6, 5);
//        Stream<Integer> integerStream1 = Stream.of(2, 4, 3, 5);
//        Set<Integer> collect = Stream.concat(integerStream, integerStream1).sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(LinkedHashSet::new));
        List<Integer> integerStream = Stream.of(1, 6, 5, 2, 4).collect(Collectors.toList());
        List<Integer> collect = integerStream.parallelStream().filter(integer -> integer != 9).collect(Collectors.toList());
        integerStream.parallelStream().filter(integer -> integer != 9).forEach(integer -> {
            System.out.println("integer = " + integer);
        });
        System.out.println("collect = " + collect);
//      System.out.println("collect = " + integerStream);
    }

    private static void findStream(List<String> list) {
        String s = list.parallelStream().filter(x -> x.equals("5")).findFirst().get();
        System.out.println("s = " + s);

        String s2 = list.parallelStream().filter(x -> x.equals("6")).findAny().orElse("a").toUpperCase(Locale.ROOT);
        System.out.println("s2 = " + s2);

    }

    /**
     * 批量处理数据
     *
     * @param list
     */
    private static void parallelStream(List<String> list) {
        long startTime = System.currentTimeMillis();
        list.stream().forEach(lis -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("lis = " + Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        list.parallelStream().forEach(lis -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("lis = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        List<String> collect = list.parallelStream().filter(lis -> {
            try {
                TimeUnit.SECONDS.sleep(4);
                System.out.println("lis = " + lis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return !lis.equals("5");
        }).collect(Collectors.toList());
        System.out.println("collect = " + collect);
        System.out.println("(parallelStream.-----System.currentTimeMillis()-end)/1000 = " + (System.currentTimeMillis() - startTime) / 1000);
        long startTimeStream = System.currentTimeMillis();
        List<String> collect1 = list.stream().filter(lis -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("lis = " + lis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return !lis.equals("5");
        }).collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);
        System.out.println("(stream System.currentTimeMillis()-end)/1000 = " + (System.currentTimeMillis() - startTimeStream) / 1000);
    }

}
