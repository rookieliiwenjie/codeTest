package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author rookie.li
 * @create 2020/10/26
 */
public class TestSimpleDateFormate {
    // (1)创建threadlocal实例
    static ThreadLocal<SimpleDateFormat> safeSdf = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static void main(String[] args) {
        // (2)创建多个线程，并启动
        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    // (3)使用单例日期实例解析文本
                    try {
                        System.out.println(safeSdf.get().parse("2017-12-13 15:17:27"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
            });
            thread.start();// (4)启动线程
        }
    }
}
