package com.company.shejimoshi.BuilderDemo.InterfeceImpl.ItmeImpl.DrinkFather.Impl;

import com.company.shejimoshi.BuilderDemo.InterfeceImpl.ItmeImpl.BurgerFather.Burger;
import com.company.shejimoshi.BuilderDemo.InterfeceImpl.ItmeImpl.DrinkFather.ColdDrink;

/**
 * @Author rookie.li
 * @create 2020/11/20
 */
public class CoKe extends ColdDrink {
    @Override
    public String name() {
        return "CoKe";
    }

    @Override
    public float price() {
        return 2.5f;
    }
}
