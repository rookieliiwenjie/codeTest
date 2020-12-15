package com.company.ThreadDemo.day02_2020_12_08;

import java.text.SimpleDateFormat;

/**
 * @Author rookie.li
 * @create 2020/12/8
 */
public class ThreadLocalDemo {
    static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-sss"));

    public static void main(String[] args) {
        ThreadLocalDemo child = new ThreadLocalDemo();
        child.dd();
        simpleDateFormatThreadLocal.get();
    }

    public void dd() {
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
    }
}
