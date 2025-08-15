package LeetCode.everyDay;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class MaximumTripletValue {

    /**
     * 给你一个下标从 0 开始的整数数组 nums 。
     * <p>
     * 请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，
     * 找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 。
     * <p>
     * 下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [12,6,1,2,7]
     * 输出：77
     * 解释：下标三元组 (0, 2, 4) 的值是 (nums[0] - nums[2]) * nums[4] = 77 。
     * 可以证明不存在值大于 77 的有序下标三元组。
     */
    public static long maximumTripletValue2(int[] nums) {
        int lenght = nums.length;
        int iNum = nums[0];
        int jNum = nums[1];
        int kNUm = nums[2];
        int resultSum = (iNum - jNum) * kNUm;
        return resultSum;
    }

    public static long maximumTripletValue(int[] nums) {
        int lenght = nums.length;
        int numsSort[][] = new int[lenght][2];
        for (int i = 0; i < lenght; i++) {
            numsSort[i][0] = nums[i];
            numsSort[i][1] = i;
        }
        Arrays.sort(numsSort, Comparator.comparingInt(a -> a[0]));
        long result = 0;
        for (int i = lenght - 1; i >= 0; i--) {
            Math.max(result,1);
        }
        return result;
    }
    public long maximumTripletValue3(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
            rightMax[n - 1 - i] = Math.max(rightMax[n - i], nums[n - i]);
        }
        long res = 0;
        for (int j = 1; j < n - 1; j++) {
            res = Math.max(res, (long)(leftMax[j] - nums[j]) * rightMax[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(maximumTripletValue(nums));
    }
}
