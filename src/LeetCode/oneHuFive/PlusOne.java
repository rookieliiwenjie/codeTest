package LeetCode.oneHuFive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        //int[] digits = {1, 2, 3};
//          int[] digits = {4, 3, 2, 1};
        int[] digits = {1, 1, 9};
        System.out.println(Arrays.toString(plusOne.plusOne2(digits)));
        System.out.println(10 / 10);
        System.out.println(10 % 10);
    }


    public int[] plusOne(int[] digits) {
        int numlen = digits.length - 1;
        int num = 1;
        for (int i = numlen; i >= 0; i--) {
            if (num != 0) {
                int Num = digits[i] + num;
                digits[i] = Num % 10;
                num = Num / 10;
            } else {
                return digits;
            }
        }
        int newLeng = numlen + 2;
        int[] newA = new int[newLeng];
        newA[0] = 1;
        //System.arraycopy(digits, 0, newA, 1, newLeng - 1);
        return newA;
    }

    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    public int[] plusOne3(int[] digits) {
        return new int[1];
    }
}
