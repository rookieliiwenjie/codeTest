package LeetCode.everyDay;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * 老板生气
 */
public class MaxSatisfied {

    public static void main(String[] args) {
        MaxSatisfied maxSatisfied = new MaxSatisfied();
        //16
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
//        int[] customers = {1};
//        int[] grumpy = {0};
//        int minutes = 1;
//        int[] customers = {4, 10, 10};
//        int[] grumpy = {1, 1, 0};
//        int minutes = 2;
        int max = maxSatisfied.maxSatisfied5(customers, grumpy, minutes);
        System.out.println(max);
    }

    /**
     * @param customers 客户
     * @param grumpy    生气值
     * @param minutes   多久不生气
     * @return 错误版本 不能排序
     */
    public int maxSatisfied(int[] customers, int grumpy[], int minutes) {
        int length = customers.length;
        int[][] mergeArr = new int[length][2];
        for (int i = 0; i < length; i++) {
            mergeArr[i][0] = customers[i];
            mergeArr[i][1] = grumpy[i];
        }
        Arrays.sort(mergeArr, Comparator.comparingInt(o -> o[0]));
        int max = 0;
        int curMax = 0;
        for (int i = length - 1; i >= 0; i--) {
            int innerMinutes = minutes;
            if (mergeArr[i][1] == 1) {
                int leftIndex = i;
                int innerMax = curMax;
                while (innerMinutes > 0 && leftIndex >= 0) {
                    innerMax += mergeArr[leftIndex][0];
                    innerMinutes--;
                    leftIndex--;
                }
                max = Math.max(max, innerMax);
            }
            if (mergeArr[i][1] == 0) {
                curMax += mergeArr[i][0];
            }
        }
        return max;

    }


    public int maxSatisfied2(int[] customers, int grumpy[], int minutes) {
        int length = customers.length;
        int max = 0;
        int curNum = 0;
        for (int i = 0; i < length; i++) {
            int innerMinutes = minutes;
            if (grumpy[i] != 1) {
                curNum += customers[i];
            } else {
                int leftIndex = i;
                int innerMax = curNum;
                while (leftIndex < length) {
                    if (innerMinutes > 0) {
                        innerMax += customers[leftIndex];
                    } else {
                        if (grumpy[leftIndex] != 1) {
                            innerMax += customers[leftIndex];
                        }
                    }
                    innerMinutes--;
                    leftIndex++;
                }
                max = Math.max(max, innerMax);
            }
        }
        return Math.max(curNum, max);
    }

    /**
     * 前缀和
     *
     * @param customers
     * @param grumpy
     * @param minutes
     * @return
     */
    public int maxSatisfied3(int[] customers, int grumpy[], int minutes) {
        int length = customers.length;
        int sum = 0;
        int addSum = 0;
        int[] sumNums = new int[length + 1];
        int[] addnums = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
                sumNums[i + 1] = sum;
            } else {
                sumNums[i + 1] = sum;
            }
            addSum += customers[i];
            addnums[i + 1] = addSum;
        }
        if (minutes == 0) {
            return sumNums[length - 1];
        }
        int max = 0;
        int newLenght = sumNums.length;
        for (int i = 0; i < newLenght; i++) {
            int index = (i + minutes);
            int left = sumNums[i];
            int right = index < newLenght ? sumNums[newLenght - 1] - sumNums[index] : 0;
            int mid = index < newLenght ? addnums[index] - addnums[i] : addnums[newLenght - 1] - addnums[i];
            int num = left + mid + right;
            max = Math.max(num, max);
        }
        return max;
    }

    /**
     * 滑动窗口
     *
     * @param customers
     * @param grumpy
     * @param minutes
     * @return
     */
    public int maxSatisfied5(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        int lenght = customers.length;
        for (int i = 0; i < lenght; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int incr = 0;
        for (int i = 0; i < minutes; i++) {
            incr += customers[i] * grumpy[i];
        }
        int maxIncr = incr;
        for (int i = minutes; i < lenght; i++) {
            int newMaxIncr = incr - customers[i - minutes] * grumpy[i - minutes] + customers[i] * grumpy[i];
            maxIncr = Math.max(maxIncr, newMaxIncr);
        }
        return total + maxIncr;
    }

    /**
     * 官方
     *
     * @param customers
     * @param grumpy
     * @param minutes
     * @return
     */
    public int maxSatisfied6(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int increase = 0;
        for (int i = 0; i < minutes; i++) {
            increase += customers[i] * grumpy[i];
        }
        int maxIncrease = increase;
        for (int i = minutes; i < n; i++) {
            increase = increase - customers[i - minutes] * grumpy[i - minutes] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return total + maxIncrease;
    }
}
