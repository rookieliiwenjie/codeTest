package com.company.javaEigt.JavaEightDemo.domain;

import lombok.ToString;

/**
 * @Author: wenjie.li
 * @Date: 2022/7/29 12:25 上午
 * @Description:
 */
@ToString
public class Apple {
    private int weight;
    private String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
