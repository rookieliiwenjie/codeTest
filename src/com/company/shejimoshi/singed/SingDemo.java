package com.company.shejimoshi.singed;

/**
 * @Author rookie.li
 * @create 2020/11/3
 */
public class SingDemo {
    private static SingDemo singDemo;

    public static SingDemo getInstance() {
        if (singDemo == null) {
            synchronized (SingDemo.class) {
                if (singDemo == null) {
                    singDemo = new SingDemo();
                }
            }
        }
        return singDemo;
    }

    public static SingDemo getInstance2() {
        if (singDemo == null) {
            singDemo = new SingDemo();
        }
        return singDemo;
    }
}
