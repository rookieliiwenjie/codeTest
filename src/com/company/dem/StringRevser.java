package com.company.dem;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;

public class StringRevser {
    public static void main(String args[]) {
       /*1.0 String x="ffn";
        String z =  x.toUpperCase();
        System.out.println(x);

        String y=x.replace('f','F');
        System.out.println(x);
        y=y+"wxy";
        System.out.println(y);*/
        //y=Ffnwxy
        ArrayList<String> a = new ArrayList<>();
        a.add("1");
        a.add("3");
        a.add(1, "2");
        int i = 1;
        opp(i++);
        String NULL = "s";
        System.out.println(i);
        ArrayList<String> b = new ArrayList<String>();

        a.subList(2, 5);
        for (String x : a) {
            System.out.println(a);
        }
    }

    static void opp(int x) {

    }
}
