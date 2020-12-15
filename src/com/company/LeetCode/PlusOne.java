package com.company.LeetCode;

import java.util.Arrays;
import java.util.PrimitiveIterator;

/**
 * @Author rookie.li
 * @create 2020/11/3
 */
public class PlusOne {
    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */


    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;

            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public static int[] plusOne2(int[] digits) {
        int num = digits.length;
        for (int i = num - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] % 10 != 0) {
                return digits;
            }
        }
        digits = new int[num + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int x = 0%10;
        System.out.println("x = " + x);
//        int[] digits = {8, 9, 9, 9};
//        int[] ints = plusOne3(digits);
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println("ints[i] = " + ints[i]);
//        }
//        int[] ints1 = plusOne22(digits);
//        PrimitiveIterator.OfInt iterator = Arrays.stream(ints1).iterator();
//        iterator.nextInt()

    }

    public static int[] plusOne3(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            ++digits[i];
            digits[i] = digits[i] % 10;
            if (digits[i] % 10 != 0) {
                return digits;
            }
        }
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }


    public static int[] plusOne22(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >=0; i--) {
            digits[i] = (digits[i]+1)%10;
            if (digits[i] % 10 != 0) {
                return digits;
            }
        }
        int newarr[] = new int[length + 1];
        newarr[0] = 1;
        return newarr;
    }
}
