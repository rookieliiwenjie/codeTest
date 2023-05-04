package com.company.shejimoshi.cheluo;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/4 10:56 上午
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Starate starate = new OneStatrate();
        starate.demo(OneStatrate.class.getName());
        Starate twoStatrate = new TwoStatrate();
        starate.demo(twoStatrate.getClass().getName());

        Centext centext = new Centext(new OneStatrate());
        centext.execton();

    }
}
