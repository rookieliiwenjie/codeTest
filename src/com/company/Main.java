package com.company;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        String s = "succcesss";
        boolean succcesssss = s.contains("succces");
        System.out.println("s = " + succcesssss);
       /* do {
            count++;
            System.out.println("count = " + count);
        } while (count < 3);
        System.out.println("count = " + count);*/
        /*Integer s2 = 10;
        Integer s1 = 9;
        Integer s3 = 15;
        List<Integer> strings = new ArrayList<>();
        strings.add(s1);
        strings.add(s3);
        strings.add(s2);
        System.out.println("strings = " + strings);
        strings.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println("strings.toString() = " + strings.toString());*/

        /*InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());
        String hostname = addr.getHostName();
        System.out.println(hostname);*/
        /*// Positive example:
        long a = System.currentTimeMillis();
        // Negative example:
        Thread.sleep(TimeUnit.SECONDS,1);
        long b = System.currentTimeMillis();

        System.out.println((a-b)/1000L);
        *//*Date date = new Date();
        System.out.print(date.getTime());*/
        /*List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("4");
        if (list.contains("4")) {
            System.out.println("存在");
        }
        if (list.contains("5")) {
            System.out.println("不存在");
        }*/
        //String s = sumFunction("123", "123");
        //System.out.println("s = " + s);
    }

    /*public static String sumFunction(String a, String b) {
        int min = Math.min(a.length(), b.length()) - 1;
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        while (min >= 0) {
            int i = Integer.valueOf(a.charAt(min)) + Integer.valueOf(b.charAt(min)) + (flag ? 1 : 0);
            if (i > 10 || i == 10) {
                flag = true;
                int yueshu = i % 10;
                stringBuilder.append(yueshu);
            } else {
                flag = false;
                stringBuilder.append(i);
            }
            min--;
        }
        if (a.length() > b.length()) {
            int del = a.length() - b.length();
            for (int i = 0; i < del; i++) {
                if (flag) {
                    stringBuilder.append(Integer.valueOf(a.charAt(i)) + 1);
                    flag = false;
                } else {

                }
            }
        } else if (a.length() == b.length()) {
            int del = chara.length - b.length();
            if (flag) {
                stringBuilder.append(1);
                flag = false;
            }
        } else {
            int del = charb.length - chara.length;
            for (int i = 0; i < del; i++) {
                if (flag) {
                    stringBuilder.append(charb[i] + 1);
                    flag = false;
                } else {
                    stringBuilder.append(charb[i]);
                }
            }
        }
        return stringBuilder.reverse().toString();
    }*/
}
