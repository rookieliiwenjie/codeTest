package com.company.shejimoshi.builder;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/22 6:49 下午
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        HouseBuilder bigHouse = new BigHouse();
        Director director = new Director(bigHouse);
        House house = director.constructHouse();
        System.out.println(house);
    }
}
