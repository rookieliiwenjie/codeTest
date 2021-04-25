package com.company.并发编程.day09_2021_2_18_3_5LOCK;

/**
 * @Author rookie.li
 * @create 2021/2/19
 */
public class FinalExample {
    int i;
    final int j;
    static FinalExample obj;

    FinalExample() {
        i = 2;
        j = 1;
    }

    public void reader() {
        //读对象引用
        FinalExample object = obj;
        //读普通域
        int a = object.i;
        // 读final域
        int b = object.j;
        System.out.println("a = 2 ?" + a);
        System.out.println("b = 1 ?" + b);
    }

    public void writer() {
        obj = new FinalExample();
    }
}
