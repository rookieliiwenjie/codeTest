package LeetCode.day06_2021_05_20;

import java.util.Arrays;

/**
 * Created by lwj32 on 2021/5/20.
 */
public class ArrayPairSum {
    /**
     * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
     */
    public static void main(String[] args) {
        int arr[] = {6, 2, 6, 5, 1, 2};
        int i = arrayPairSum(arr);
        System.out.println("i = " + i);
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int x = nums.length;
        int sum = 0;
        for (int i = 0; i < x; i+=2) {
            sum += nums[i];
        }
        return sum;
    }

    public int countPalindromicSubsequences(String s) {
        char[] chars = s.toCharArray();
        int sum = chars.length;
        for (int i=0;i<chars.length;i++){
            for (int j = i+1; j < chars.length; j++) {
                //String
            }
        }
   return 0;
    }

}
