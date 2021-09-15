package com.company;


import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author rookie.li
 * @create 2020/10/26
 */
public class Caltroer {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        calendar.set(2020, 9, 11, 23, 45, 12);
        Date time = calendar.getTime();
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(time);
        Date time1 = calendar.getTime();
        System.out.println("time1 = " + time1);
        calendar.setTime(time1);
        System.out.println("calendar = " + calendar);
      /*  System.out.println("calendar3 = " + calendar);
        System.out.println("time = " + time);
        System.out.println("calendar = " + calendar);
        System.out.println("calendar.getTimeZone() = " + calendar.getTimeZone());
        System.out.println("calendar.getWeekYear() = " + calendar.getWeekYear());
        System.out.println("calendar.getWeeksInWeekYear() = " + calendar.getWeeksInWeekYear());
        System.out.println("calendar.getCalendarType() = " + calendar.getCalendarType());
        TimeZone timeZone = calendar.getTimeZone();
        String id = timeZone.getID();
        System.out.println("calendar.getTimeZone().getID() = " + id);*/
    }
}
