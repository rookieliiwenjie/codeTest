package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author rookie.li
 * @create 2020/10/28
 */
public class CalanterThread {
    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Date endTime = format("endTime", new Date());
                System.out.println("endTime = " + endTime);
            }).start();
        }
//        Date endTime = format("endTime", new Date());
//        System.out.println("endTime = " + endTime);

    }

    /*public static Date format(String type, String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if ("startTime".equals(type)) {
                String startTime = date + " 00:00:00";
                return threadLocal.get().parse(startTime);
            } else if ("endTime".equals(type)) {
                String endTime = date + " 23:59:59";
                return threadLocal.get().parse(endTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期格式有误，正确格式为yyyy-MM-dd");
        }
        return null;
    }
*/
    public static Date format(String type, Date date) {
        try {
            if ("startTime".equals(type)) {
                String startTime = format.format(date) + " 00:00:00";
                return format.parse(startTime);
            } else if ("endTime".equals(type)) {
                String endTime = format.format(date) + " 23:59:59";
                return format.parse(endTime);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期格式有误，正确格式为yyyy-MM-dd");
        }
        return null;
    }
}
