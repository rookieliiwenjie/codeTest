package com.company.并发编程.day15_2021_03_02;

import java.util.concurrent.TimeUnit;

/**
 * @Author rookie.li
 * @create 2021/3/2
 * @desc 调用一个方法时等待一段时间(一般来说是给 定一个时间段)，
 * 如果该方法能够在给定的时间段之内得到结果，那么将结果立刻返回
 * ，反之， 超时返回默认结果。
 */
public class WiatDemo {
    public String result = null;

    public static void main(String[] args) {
    }

    public synchronized Object get(long mille) throws InterruptedException {
        long feature = System.currentTimeMillis() + mille;
        long time = mille;
        while (result == null && time > 0) {
            wait(time);
            time = feature - System.currentTimeMillis();

        }
        return result;
    }
}
