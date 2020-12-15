package com.company.Stringdemo;


import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;

/**
 * @Author rookie.li
 * @create 2020/10/29
 */
public class StringDemo extends Thread{
    @Override
    public void run() {
        System.out.println("thread " + currentThread().getName());
    }

    static class demo implements Runnable {

        @Override
        public void run() {
            Thread.currentThread().setName("Ruanable");
            System.out.println("runable" );
        }
    }
    public static void main(String[] args) {
        demo demo = new demo();

        demo.run();
        Thread thread = new Thread(()->{
            System.out.println("  fdfdf" );
        });

        thread.start();
      /*  String s = "dfdf  fdfdf       fdf          fdfdf      fd";
        String[] split = s.split("d");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < split.length; i++) {
            System.out.println("split = " + split[i]);
            if (split[i].length() > 0) {
                arrayList.add(split[i]);
            }
        }
        System.out.println("arrayList = " + arrayList);*/
    }
}
