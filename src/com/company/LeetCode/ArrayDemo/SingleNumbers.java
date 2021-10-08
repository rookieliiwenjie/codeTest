package com.company.LeetCode.ArrayDemo;

import java.util.Arrays;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-10-07 21:40
 */
public class SingleNumbers {

    public int[] singleNumbers(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            if (nums[i] != nums[i + 1]) {

            }

        }
        return nums;
    }
}
