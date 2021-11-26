package com.company.LeetCode;

/**
 * @Author rookie.li
 * @create 2021/3/19
 */
public class MonkeyDemo {
    public static void main(String[] args) {
        int i = 9;
        int x = 1;
        while (i > 0) {
            x = (x + 1) * 2;
            System.out.println("x = " + x);
            i--;
        }
    }
}
