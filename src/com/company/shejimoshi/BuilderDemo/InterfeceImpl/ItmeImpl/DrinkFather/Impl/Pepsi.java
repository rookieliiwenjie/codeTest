package com.company.shejimoshi.BuilderDemo.InterfeceImpl.ItmeImpl.DrinkFather.Impl;

import com.company.shejimoshi.BuilderDemo.InterfeceImpl.ItmeImpl.DrinkFather.ColdDrink;

/**
 * @Author rookie.li
 * @create 2020/11/20
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 2.5f;
    }
}
