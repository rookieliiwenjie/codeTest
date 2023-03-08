package com.company.javaEigt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/6 4:21 下午
 * @Description:
 */
public class DemoRemove {
    private static final String s = "liu";
    public static void main(String[] args) {
        List<String> listArr = new ArrayList<>();
        listArr.add("li");
        listArr.add("liuhang3dd");
        listArr.add("wen");
        listArr.add("jie");
        listArr.add("liuhang3");
        listArr.add("liuddd");
        listArr.add("hang");
        listArr.add("liuhang");
        //1、正向删除（不可靠）
//        for (int i = 0; i < listArr.size(); i++) {
//            System.out.println("i = " + i);
//            if (listArr.get(i).startsWith(s)) {
//                listArr.remove(i);
//            }
//        }
        //2、正向提取 size 变量 ，删除 （抛出异常）
//        int size = listArr.size();
//        for (int i = 0; i < size; i++) {
//            String str = listArr.get(i);
//            if (str.startsWith(s)) {
//                listArr.remove(i);
//            }
//        }
        //3、逆向删除 不带变量（可靠）
//        for (int i = listArr.size() - 1; i >= 0; i--) {
//            String str = listArr.get(i);
//            if (str.startsWith(s)) {
//                listArr.remove(i);
//            }
//        }
        //4、逆向删除 带变量（可靠）
        int size = listArr.size();
        for (int i = size - 1; i >= 0; i--) {
            String str = listArr.get(i);
            System.out.println("i " + i);
            System.out.println("before --listArr.size() = " + listArr.size());
            if (str.startsWith(s)) {
                listArr.remove(i);
            }
            System.out.println("after --listArr.size() = " + listArr.size());
        }
        System.out.println("listArr = " + listArr);

    }
}
