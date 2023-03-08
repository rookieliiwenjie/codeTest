package com.company.javaEigt.JavaEightDemo.domain;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/6 2:47 下午
 * @Description:
 */
public class ForDemoRetryDemo {
    public static void main(String[] args) {
//        retry:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 4) {
//                    break retry;
                    break;
                }
                System.out.print(j + ",");
            }
            System.out.println("-");
        }

    }
}
