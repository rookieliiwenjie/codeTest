package com.company.shejimoshi.FlyweightDemo.TreeDemo;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            TreeFactory.getTreeType("sunshu", "black", "chang").draw(i, i);
        }
    }
}
