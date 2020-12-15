package com.company.shejimoshi.BuilderDemo.InterfeceImpl.ItmeImpl.BurgerFather.Impl;

import com.company.shejimoshi.BuilderDemo.InterfeceImpl.ItmeImpl.BurgerFather.Burger;

/**
 * @Author rookie.li
 * @create 2020/11/20
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "chickenBurger";
    }

    @Override
    public float price() {
        return 1.5f;
    }
}
