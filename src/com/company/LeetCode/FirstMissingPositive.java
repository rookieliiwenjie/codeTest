package com.company.LeetCode;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-09-26 23:53
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }
}
