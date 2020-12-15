package com.company.Stringdemo;


import java.util.HashMap;

/**
 * Created by lwj32 on 2020/8/29.
 */
public class StringStudy {
    public static void main(String[] args) {
        Object[] objects = new String[]{"str", "str2"};
        String s = "ab" + "c";
        String a = "abc";
        char[] chars = {'a', 'b', 'c'};
        System.out.println("s.equals(a) = " + s.equals(a));
        System.out.println("chars = " + a.equals(chars));
        HashMap hashMap = new HashMap();
        hashMap.remove(1);
        hashMap.containsKey(1);
        /*String c = "abc";
        String li = "liwenjie";
        String jei = "liwen" + "jie";
        System.out.println("li=-jei = " + li.equals(jei));
        System.out.println("c==a = " + c == a);
        String st = new String("abc");

        System.out.println("s==a = " + s == a);
        StringBuffer stringBuffer = new StringBuffer();
        Object object = "11";
        Object object1 = "11";
        Integer integer = Integer.valueOf(1);
        System.out.println("object1 = " + object.equals(object1));
        StringBuilder stringBuilder = new StringBuilder();*/
    }
}
