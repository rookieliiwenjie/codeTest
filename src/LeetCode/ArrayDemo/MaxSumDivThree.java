package LeetCode.ArrayDemo;

import java.util.Arrays;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/19 2:31 下午
 * @Description:
 */
public class MaxSumDivThree {
    public static void main(String[] args) {
//        maxSumDivThree();
    }

    public static int maxSumDivThree(int nums[]) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            if (num % 3 == 0) {
                sum += num;
            }
        }
        return sum;
    }
}
