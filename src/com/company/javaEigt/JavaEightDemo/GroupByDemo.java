package com.company.javaEigt.JavaEightDemo;

import com.company.javaEigt.JavaEightDemo.domain.CaloricLevel;
import com.company.javaEigt.JavaEightDemo.domain.Menu;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/21 9:51 上午
 * @Description:
 */
public class GroupByDemo {

    public static void main(String[] args) {
        List<Menu> menu = Menu.createMenu();
        groupByDemo(menu);
    }

    public static void groupByDemo(List<Menu> menus) {
        Map<Object, ConcurrentMap<Boolean, Map<Integer, List<Menu>>>> collect = menus.stream().filter(menu -> menu.getHeat() != null)
                .collect(groupingBy(dish -> {
                    if (dish.getHeat() <= 400) {
                        return "gao";
                    } else if (dish.getHeat() <= 1000) {
                        return "gao";
                    } else {
                        return "gao";
                    }
                }, groupingByConcurrent(Menu::isQuantityOfHeat, groupingBy(Menu::getPrice))));

        System.out.println("collect.toString() = " + collect.toString());

    }

    static <T> Collector<T, ?, List<T>> toSortedList(Comparator<? super T> c) {
        return Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(c)), ArrayList::new);
    }

    public static void reduceDmo(List<Menu> menu) {

    }
}
