package com.company;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @Author rookie.li
 * @create 2020/10/29
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        System.out.println("simpleDateFormat = " + simpleDateFormat.format(date));
    }
}
