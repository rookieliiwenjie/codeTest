package com.company.面试准备;

/**
 * Created by lwj32 on 2021/5/18.
 */
public class ThreadDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(1 / 0);
    }

}
