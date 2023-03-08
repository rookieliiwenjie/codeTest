package com.company.javaEigt.JavaEightDemo.chapterThree;

import com.company.javaEigt.JavaEightDemo.domain.Menu;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * @Author: wenjie.li
 * @Date: 2022/9/6 9:06 上午
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        List<Menu> menu = Menu.createMenu();
        /**
         * 1.map 是中间操作
         * 2.collect是终端操作
         */
//        List<Integer> nameLength = menu.stream().map(Menu::getName).filter(Objects::nonNull).map(String::length).sorted(Comparator.reverseOrder()).limit(2).collect(Collectors.toList());
//        nameLength.stream().forEach(System.out::println);
//        List<String> nameLength2 = menu.stream().sorted(Comparator.comparing(Menu::getPrice)).map(Menu::getName).collect(Collectors.toList());
//        menu.stream().forEach(System.out::println);

            
       // faltMapAndMap(menu);

        List<String> list = menu.parallelStream().map(Menu::getName).filter(men -> !men.equals("龙虾饭")).collect(toList());
        System.out.println("list = " + list);
    }

    public static void faltMapAndMap(List<Menu> menu) {
        String[] arr = {"Hello","World"};
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");
        /**
         * 错误的方法
         */
        List<String[]> collect = strings.stream()
                .map(ar -> ar.split(""))
                .distinct()
                .collect(toList());
//        List<String[]> collect1 = strings.stream()
//                .map(word -> word.split(""))
//                .distinct()
//                .collect(toList());
//        collect1.forEach(co-> Arrays.stream(co).forEach(System.out::println));
        /**
         * 扁平化流处理
         * flatmap
         */
//        strings.stream().map(s -> s.split("")).flatMap(s -> s.split(""));
//        strings.stream().flatMap(s -> s.split(""));
        collect.forEach(co-> Arrays.stream(co).forEach(System.out::println));
        System.out.println("collect = " + collect);
    }
}
