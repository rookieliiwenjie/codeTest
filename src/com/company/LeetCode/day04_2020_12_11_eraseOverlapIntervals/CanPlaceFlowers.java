package com.company.LeetCode.day04_2020_12_11_eraseOverlapIntervals;

import java.util.Arrays;
import java.util.function.IntPredicate;

/**
 * @Author rookie.li
 * @create 2020/12/11
 */
public class CanPlaceFlowers {
    /**
     * 假设你有一个很长的花坛，一部分地块种植了花，
     * 另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花）
     * ，和一个数n。能否在不打破种植规则的情况下种入n朵花？能则返回True，
     * 不能则返回False。
     * 输入: flowerbed = [1,0,0,0,1], n = 1
     * 输出: True
     * 示例 2:
     * 输入: flowerbed = [1,0,1,0,1], n = 2
     * 输出: False
     * 数组内已种好的花不会违反种植规则。
     * 输入的数组长度范围为 [1, 20000]。
     * n 是非负整数，且不会超过输入数组的大小。
     */
    public static void main(String[] args) {
        int n = 1;
        int arr[] = {0,1,0};

        //boolean b = canPlaceFlowers(arr, n);
        boolean b1 = canPlaceFlowers2(arr, n);
        System.out.println("canPlaceFlowers2 = " + b1);
       // System.out.println("b = " + b);
    }

    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        //数组内已种好的花不会违反种植规则
        int num = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed.length == 1) {
                if (flowerbed[0] == 0) {
                    ++num;
                    flowerbed[i] = 1;
                }
            } else {
                if (((i == 0 && flowerbed[i + 1] == 0) || (i == flowerbed.length - 1 && flowerbed[i - 1] == 0))) {
                    ++num;
                    flowerbed[i] = 1;
                } else {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        ++num;
                        flowerbed[i] = 1;
                    }
                }
            }


        }

        /*long count = Arrays.stream(flowerbed).filter(flowerbe -> flowerbe == 1).count();
        int lenght = flowerbed.length % 2 == 0 ? flowerbed.length/2 : flowerbed.length/2 + 1;*/
        return num == n;
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        //数组内已种好的花不会违反种植规则
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            //如果为0的
            if (flowerbed[i] == 0) {
                //如果是第一个或者前一个为0
                if ((i == 0 || flowerbed[i - 1] == 0)) {
                    //如果是最后一个而且前一个为0
                    if ((i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                        flowerbed[i] = 1;
                        count++;
                    }

                }

            }
            i++;
        }
        return count >= n;

    }
}
