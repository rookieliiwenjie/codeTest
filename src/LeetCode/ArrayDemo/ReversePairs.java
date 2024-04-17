package LeetCode.ArrayDemo;

import java.util.Arrays;

public class ReversePairs {
    /**
     * 超时版本
     *
     * @param nums
     * @return
     */
    public int reversePairs(int nums[]) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public int reversePairs2(int nums[]) {
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (i, j) -> nums[i] - nums[j]);
        int sum = 0;
        return sum;
    }
}
