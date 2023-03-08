package com.company.javaEigt.JavaEightDemo.chapterTwo;


import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: wenjie.li
 * @Date: 2022/10/10 6:26 下午
 * @Description:
 */
public class demo {
    public static void main(String[] args) {
//        String[] split = newxx.split(",");
//        String[] newsp = new String[split.length];
//        for (int j = 0;j<split.length;j++){
//            String s  =split[j];
//            for (int i = 0;i<s.length();i++){
//                if(s.charAt(i)==' '){
//                    System.out.println(s);
//                    System.out.println(s.trim());
//                    s=s.trim();
//                    System.out.println(s);
//                    newsp[j] = s;
//                }else {
//                    newsp[j] = s;
//                }
//            }
//        }
//
//        String join = StringUtils.join(Arrays.asList(newsp), ",");
//        System.out.println("join = " + join);
//        System.out.println("split = " + split);
//        System.out.println("split = " + de.split(",").length);
//        System.out.println("mew.split(\",\").length = " + mew.split(",").length);
//        System.out.println("x.split(\",\").length = " + x.split(",").length);
//        System.out.println("newxx.length() = " + newxx.split(",").length);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("1");
//        Map<String,String> map = list.stream().collect(Collectors.toMap(e->e, e->e,(e1,e2)->e1));
        List<String> collect = list.stream().skip(2).collect(Collectors.toList());
        System.out.println("collect = " + collect);
       // System.out.println("map.keySet()+map.values() = " + map.keySet()+map.values());
        
    }
}
