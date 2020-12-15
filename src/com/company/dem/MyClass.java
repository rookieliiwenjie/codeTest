package com.company.dem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyClass {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String args[]) {
        try {
            Date date = simpleDateFormat.parse("2015-01-21");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            System.out.println(calendar.get(Calendar.YEAR));
            System.out.println(calendar.get(Calendar.MONTH) + 1);
            System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println((calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}