package com.company.javaEigt.JavaEightDemo.ExecutorsDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/14 9:38 上午
 * @Description:
 */
public class SimpleDataFormatDemo {


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        while (true) {
            threadPoolExecutor.execute(() -> {
                String format = simpleDateFormat.format(new Date());
                String dates = null;
                try {
                    Date parse = simpleDateFormat.parse(format);
                    dates = simpleDateFormat.format(parse);
                    System.out.println("format.equals() = " + format.equals(dates));
                    System.out.println("format = " + format + "    dates =" + dates);
                } catch (ParseException e) {
                    System.out.println("ERROR format = " + format + "    dates =" + dates);
                    e.printStackTrace();
                }
            });
        }
    }
}
