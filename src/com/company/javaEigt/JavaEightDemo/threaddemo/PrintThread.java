package com.company.javaEigt.JavaEightDemo.threaddemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/9 5:22 下午
 * @Description:
 */
public class PrintThread implements Runnable {
    int printNum;
    String name;

    public PrintThread(int printNum, String name) {
        this.printNum = printNum;
        this.name = name;
    }

    public int getPrintNum() {
        return printNum;
    }

    public void setPrintNum(int printNum) {
        this.printNum = printNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < printNum; ) {

        }
    }
}
