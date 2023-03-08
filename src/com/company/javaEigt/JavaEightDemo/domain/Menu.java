package com.company.javaEigt.JavaEightDemo.domain;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2022/9/6 9:02 上午
 * @Description:
 */
@ToString
public class Menu {
    private String name;
    private boolean quantityOfHeat;
    private Integer price;
    private Integer heat;

    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }

    public boolean isQuantityOfHeat() {
        return quantityOfHeat;
    }

    public void setQuantityOfHeat(boolean quantityOfHeat) {
        this.quantityOfHeat = quantityOfHeat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public static List<Menu> createMenu() {
        List<Menu> menuList = new ArrayList<>();
        Menu menu = new Menu();
        menu.setName("鱼香肉丝");
        menu.setQuantityOfHeat(true);
        menu.setPrice(10);
        menu.setHeat(100);
        menuList.add(menu);
        Menu menu2 = new Menu();
        menu2.setName("驴肉火烧");
        menu2.setQuantityOfHeat(false);
        menu2.setPrice(100);
        menu2.setHeat(400);
        menuList.add(menu2);
        Menu menu3 = new Menu();
        menu3.setName("龙虾饭");
        menu3.setQuantityOfHeat(true);
        menu3.setHeat(1000);
        menu3.setPrice(80);
        menuList.add(menu3);
        Menu menu4 = new Menu();
        menu4.setName("麻辣烫");
        menu4.setHeat(1100);
        menu4.setQuantityOfHeat(false);
        menu4.setPrice(60);
        menuList.add(menu4);
        Menu menu5 = new Menu();
        menu5.setName("火锅");
        menu5.setHeat(300);
        menu5.setQuantityOfHeat(true);
        menu5.setPrice(130);
        menuList.add(menu5);
        return menuList;
    }

}
