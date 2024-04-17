package LeetCode.ArrayDemo;

import java.util.Arrays;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/4 2:36 下午
 * @Description:
 */
public class MaxTrixSum {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int nums[][] = {{7, 2, 1}, {6, 4, 2}, {6, 5, 3}, {3, 2, 1}};
        //int nums[][] = {{1}};
      //  matrixSum(nums);
        Class clz = Class.forName("LeetCode.ArrayDemo.MaxTrixSum");
        MaxTrixSum maxTrixSum = (MaxTrixSum)clz.newInstance();
        maxTrixSum.matrixSum2(nums);
    }
    public  int matrixSum2(int nums[][]) {
        int maxSum = 0;
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        for (int i = 0; i < nums[0].length; i++) {
            int max = 0;
            for (int[] num : nums) {
                max = Math.max(num[i], max);
            }
            maxSum = max + maxSum;
        }
        return maxSum;
    }
    public static int matrixSum(int nums[][]) {
        int maxSum = 0;
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        for (int i = 0; i < nums[0].length; i++) {
            int max = 0;
            for (int[] num : nums) {
                max = Math.max(num[i], max);
            }
            maxSum = max + maxSum;
        }
        return maxSum;
    }
}
