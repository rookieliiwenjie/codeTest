package com.company.Thread;

/**
 * Created by lwj32 on 2020/8/4.
 */
public class SingleClassDemo {
    private static volatile SingleClassDemo singleClassDemo;

    public SingleClassDemo getIntface() {
        if (singleClassDemo == null) {

            synchronized (SingleClassDemo.class) {
                if (singleClassDemo == null) {
                    singleClassDemo = new SingleClassDemo();
                }
            }
        }
        return singleClassDemo;

    }
}
