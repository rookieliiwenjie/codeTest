package LeetCode.everyDay;

import java.util.Arrays;

public class MissingRolls {
    public static void main(String[] args) {
        MissingRolls missingRolls = new MissingRolls();
//        int[] rolls = {1, 5, 6};
//        int mean = 3;
//        int n = 4;
//        int[] rolls = {3, 2, 4, 3};
//        int mean = 4;
//        int n = 2;
//        int[] rolls = {1, 2, 3, 4};
//        int mean = 6;
//        int n = 4;

//        int[] rolls = {1};
//        int mean = 3;
//        int n = 1;
        int[] rolls = {3, 5, 3};
        int mean = 5;
        int n = 3;
        System.out.println(-6 % 6);
        int[] result = missingRolls.missingRolls(rolls, mean, n);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * @param rolls 没
     * @param mean  平均值
     * @param n
     * @return
     * 和我想的一样，但是我 这边是加法，他那边是减法，但是速度上差距了百7主要是我这里海设计判断也多，还是没有想好
     * 他的做法就是算出来 算出来
     */
    public int[] missingRolls(int rolls[], int mean, int n) {
        int[] result = new int[n];
        int sum = 0;
        for (int num : rolls) {
            sum += num;
        }
        int k = n + rolls.length;
        int nNum = mean * k - sum;
        //low的版本
//        if ((nNum / n > 6) || nNum / n < 1 || (nNum / n == 6 && nNum % n > 0)) {
//            return new int[0];
//        }
        if(nNum<n || nNum>6*n){
            return new int[0];
        }
        int pingJun = nNum / n;
        nNum = nNum % n;
        for (int i = 0; i < n; i++) {
            result[i] = pingJun + (nNum > 0 ? 1 : 0);
            nNum--;
        }
        return result;

    }

    public int[] missingRolls3(int rolls[], int mean, int n) {
        int m = rolls.length;
        int sum = mean * (n + m);
        int missingSum = sum;
        for (int roll : rolls) {
            missingSum -= roll;
        }
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }
        int quotient = missingSum / n, remainder = missingSum % n;
        int[] missing = new int[n];
        for (int i = 0; i < n; i++) {
            missing[i] = quotient + (i < remainder ? 1 : 0);
        }
        return missing;

    }

    public int[] missingRolls2(int rolls[], int mean, int n) {
        int[] result = new int[n];
        int m = rolls.length;
        int mSum = 0;
        int size = Math.max(m, n);
        for (int i = 0; i < size; i++) {
            if (i < m) {
                mSum += rolls[i] - mean;
            }
            if (i < n) {
                result[i] = mean;
            }
        }
        if (mSum % n != 0) {
            return new int[0];
        }
        return result;

    }
}
