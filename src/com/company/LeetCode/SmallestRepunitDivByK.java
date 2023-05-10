package com.company.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/10 11:15 上午
 * @Description:
 */
public class SmallestRepunitDivByK {
    public int SmallestRepunitDivByK(int k) {
        int n = 1;
        int num = 1 % k;
        Set<Integer> ySet = new HashSet<>();
        ySet.add(num);
        while (num != 0) {
            num = ((num % k * 10) + 1) % k;
            if (num == 0) {
                return n+1;
            }
            if (ySet.contains(num)) {
                return -1;
            }
            ySet.add(num);
            n++;

        }
        return n;
    }
    public int SmallestRepunitDivByK2(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int n = 1;
        int num = 1 % k;
        while (num != 0) {
            num = ((num % k * 10) + 1) % k;
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println("2%3 = " + 2 % 3);
    }
}
