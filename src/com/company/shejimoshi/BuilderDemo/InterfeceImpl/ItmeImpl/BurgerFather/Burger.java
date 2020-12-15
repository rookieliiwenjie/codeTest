package com.company.shejimoshi.BuilderDemo.InterfeceImpl.ItmeImpl.BurgerFather;

import com.company.shejimoshi.BuilderDemo.Interfece.Item;
import com.company.shejimoshi.BuilderDemo.Interfece.Packing;
import com.company.shejimoshi.BuilderDemo.InterfeceImpl.PackImpl.Wrapper;

/**
 * h@Author rookie.li
 * @create 2020/11/17
 * 创建实现 Item 接口的抽象类，该类提供了默认的功能。
 */
public abstract class Burger implements Item {

    @Override
    public abstract float price();

    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
