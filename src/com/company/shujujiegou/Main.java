package com.company.shujujiegou;

import java.util.Scanner;

public class Main {

    public static void main(String args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int y = 0; y < n; y++) {
            arr[y] = sc.nextLong();
        }
        getLargestMul(arr, n);
    }

    static void getLargestMul(long[] arr, int n) {
        //定义五个数因为有负数的可能所以要定义两个最小数
        //解题思路当一个数组传进来是分为三种情况1.为正2.为负3.为0
        //所以我们要将每一个数分为5种情况和我们定义的五个数进行比较
        long max = 0;
        long max_second = 0;
        long max_third = 0;
        long min = 0;
        long min_second = 0;
        for (int x = 0; x < n; x++) {
            if (arr[x] != 0) {
                if (arr[x] > max) {
                    max = arr[x];
                    max_second = max;
                    max_third = max_second;

                } else if (arr[x] > max_second) {
                    max_second = arr[x];
                    max_third = max_second;

                } else if (arr[x] > max_third) {
                    max_third = arr[x];
                } else if (arr[x] < min) {
                    min = arr[x];
                    min_second = min;
                } else if (arr[x] < min_second) {
                    min_second = arr[x];

                }
            } else {
                continue;
            }
        }
        long z = Math.max(max_second * max * max_third, max * min * min_second);
        System.out.println();
    }

}