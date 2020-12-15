package com.company.Java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Created by lwj32 on 2020/10/12.
 */
public class ObjectDemo {
    public static void main(String[] args) {
       /* Integer i = 199999;
        Integer z = 199999;
        Object object =z;
        Object object2 = i;
        String s = "abc";
        object.toString();
        //Objects.equals(11);
        System.out.println("object2 = " + object.equals(object2));
        if (object instanceof Object){
            System.out.println("true = " + true);

        }*/
        /*Date date  = new Date(0L);
        System.out.println("date = " + date);
        long time = date.getTime();*/
        System.out.println("args = " + LocalDateTime.now().getDayOfYear());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateText = simpleDateFormat.format(new Date());
        try {
            Date date = simpleDateFormat.parse("1888/10/25 16:51:10");
            System.out.println("date = " + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        try {
            Class cls = Class.forName("");
            Constructor constructor =  cls.getConstructor();
            constructor.newInstance();

            try {
                cls.getMethod("getName");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("calendar = " + calendar);
        //System.out.println("dateText = " + dateText);

    }
}

