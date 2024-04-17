package LeetCode.ArrayDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/11 3:10 下午
 * @Description:
 */
public class MaxAlternatingSum {

    public static long maxAlternatingSum(int nums[]) {
        long even = nums[0], ood = 0;
        for (int i = 1; i < nums.length; i++) {
            //偶数
            even = Math.max(even, ood + nums[i]);
            //奇数
            ood = Math.max(ood, even - nums[i]);
        }
        return even;
    }

    public static void main(String[] args) {
//        while (true) {
//            System.out.println("args = " + args);
//        }

        int nums[] = {4, 2, 5, 3};
        System.out.println("nums = " + maxAlternatingSum(nums));
        System.out.println("nums = " + maxAlternatingSubsequenceSum2(nums));
    }

    public static int maxAlternatingSubsequenceSum2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < n; i++) {
//            if (nums[i] * nums[i - 1] > 0) {
//                minSum = maxSum = Math.max(maxSum, minSum);
//            } else {
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            minSum = Math.min(minSum + nums[i], nums[i]);
//            }
        }

        return Math.max(maxSum, minSum);
    }


}
