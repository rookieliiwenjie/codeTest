package com.company.SingleonDemo;


/**
 * Created by lwj32 on 2020/6/19.
 */
public class SingleonDemo {
    //valatile防止aba问题
    public static volatile SingleonDemo instance = null;
    public static SingleonDemo getInstance() {
        if (instance == null) {
            synchronized (SingleonDemo.class) {
                if (instance == null) {
                     instance = new SingleonDemo();

                }
            }
        }
        return instance;
    }


}
