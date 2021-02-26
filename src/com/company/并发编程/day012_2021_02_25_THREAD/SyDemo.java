package com.company.并发编程.day012_2021_02_25_THREAD;

/**
 * @Author rookie.li
 * @create 2021/2/25
 * JAVAC XX.JAVA
 * JAVAP -V CLASS
 */
public class SyDemo {
    public static void main(String[] args) {
// 对Synchronized Class对象进行加锁 synchronized (Synchronized.class) { }
        // 静态同步方法，对Synchronized Class对象进行加锁
        synchronized (SyDemo.class){
            m();
        }
    }

    public static synchronized void m() {
    }
}
