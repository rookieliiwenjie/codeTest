package com.company.shejimoshi.decoratordemo;

/**
 * 实现基础功能的具体类
 */
public class SimpleCoffee implements Coffee{
    @Override
    public double getCost() {
        return 2.0;
    }

    @Override
    public String getDescription() {
        return "simple_coffee";
    }
}
