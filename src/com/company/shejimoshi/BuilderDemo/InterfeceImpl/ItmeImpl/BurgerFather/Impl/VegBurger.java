package com.company.shejimoshi.BuilderDemo.InterfeceImpl.ItmeImpl.BurgerFather.Impl;

import com.company.shejimoshi.BuilderDemo.InterfeceImpl.ItmeImpl.BurgerFather.Burger;

/**
 * @Author rookie.li
 * @create 2020/11/20
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "VegBurger";
    }

    @Override
    public float price() {
        return 2.5f;
    }
}
