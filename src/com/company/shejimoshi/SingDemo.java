package com.company.shejimoshi;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/4 10:24 上午
 * @Description:
 */
public class SingDemo {

    private volatile static SingDemo instance;

    public static SingDemo getInstance() {
        if (instance == null) {
            synchronized (SingDemo.class) {
                if (instance == null) {
                    instance = new SingDemo();
                }
            }
        }
        return instance;
    }
}
