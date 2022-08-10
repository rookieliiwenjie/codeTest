package com.company.javaEigt.JavaEightDemo.domain;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2022/7/29 12:25 上午
 * @Description:
 */
@ToString
public class Apple implements Comparable<Apple> {
    private Integer weight;
    private String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple() {
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static List<Apple> getAppleList() {
        List<Apple> appleList = new ArrayList<>();
        Apple apple = new Apple();
        apple.setColor("green");
        apple.setWeight(160);
        appleList.add(apple);
        Apple apple2 = new Apple();
        apple2.setColor("black");
        apple2.setWeight(140);
        appleList.add(apple2);
        Apple apple3 = new Apple();
        apple3.setColor("blue");
        apple3.setWeight(190);
        appleList.add(apple3);
        return appleList;
    }

    @Override
    public int compareTo(Apple o) {
        return this.getWeight().compareTo(o.getWeight());
    }
}
