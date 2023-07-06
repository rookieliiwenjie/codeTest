package com.company.LeetCode.mathType;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/6 11:00 上午
 * @Description:
 */
public class MaximumEcenSplit {
    public static void main(String[] args) {
        System.out.println("args = " + maximumEvenSplit2(12));
    }

    /**
     * 1.遇到后续除不净的如何办
     *
     * @param finalSum
     * @return
     */
    public static List<Long> maximumEvenSplit(long finalSum) {
        List<Long> list = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return list;
        }
        long numSum = finalSum;
        long sumNum = finalSum / 2;
        long sum = 0;
        for (long i = 1; i <= sumNum; i++) {
            long x = i * 2;
            long x2 = (i + 1) * 2;
            long num2 = finalSum - x - x2;
            if (num2 == 0) {
                list.add(x);
                list.add(x2);
                break;
            } else if (num2 < 0) {
                list.add(finalSum);
                break;
            }
            finalSum = finalSum - x;
            sum += x;
            list.add(x);
            if (sum >= numSum) {
                break;
            }
        }
        return list;
    }

    public List<Long> maximumEvenSplit3(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 > 0) {
            return res;
        }
        for (long i = 2; i <= finalSum; i += 2) {
            res.add(i);
            finalSum -= i;
        }
        res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);
        return res;
    }


    public static List<Long> maximumEvenSplit2(long finalSum) {
        List<Long> list = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return list;
        }
        for (long i = 2; i <= finalSum; i += 2) {
            long num = finalSum - i;
            if (num < 0) {
                break;
            }
            finalSum = finalSum - i;
            list.add(i);
        }
        if (finalSum > 0) {
            list.set(list.size() - 1, list.get(list.size() - 1) + finalSum);
        }
        return list;
    }

    public static List<Long> maximumEvenSpli5(long finalSum) {
        List<Long> list = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return list;
        }
        for (long i = 2; i <= finalSum; i += 2) {
            list.add(i);
            finalSum = finalSum - i;
        }
        list.set(list.size() - 1, list.get(list.size() - 1) + finalSum);
        return list;
    }


    public static int[] splitIntoMaximumEvenNumbers(int finalSum) {
        List<Integer> numbers = new ArrayList<>();
        int sum = 0;

        for (int num = 2; sum + num <= finalSum; num += 2) {
            numbers.add(num);
            sum += num;
        }
        if (sum == finalSum) {
            int[] result = new int[numbers.size()];
            for (int i = 0; i < numbers.size(); i++) {
                result[i] = numbers.get(i);
            }
            return result;
        } else {
            return new int[0]; // 返回空数组表示无法拆分
        }
    }
}
