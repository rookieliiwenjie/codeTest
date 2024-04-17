package LeetCode.ArrayDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/11 7:52 下午
 * @Description:
 */
public class MaxSubArray {
    /**
     * @param nums
     * @return
     */
    public static int maxSubArray(int nums[]) {
        int newNum[] = new int[nums.length];
        newNum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            newNum[i] = newNum[i - 1] + nums[i];
        }
        int left = 0;
        int right = newNum.length - 1;
        int sum = newNum[0];
        int min = newNum[left];
        while (left < right) {
            sum = Math.max(sum, newNum[right] - newNum[left]);
            if (newNum[left] < min) {

            }
        }
        return sum;
    }

    /**
     * 暴力法，超出时间限制
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int nums[]) {
        if (nums.length <= 0) {
            return 0;
        }
        int sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int num = 0;
            for (int j = i; j < nums.length; j++) {
                num += nums[j];
                sum = Math.max(sum, num);
            }
        }
        return sum;
    }

    /**
     * 动态规划
     * dp[i] = nums[i] + num[i-1] + num[i-2] +...
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int nums[]) {
        if (nums.length <= 0) {
            return 0;
        }
        int sum = nums[0], pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            sum = Math.max(sum, pre);
        }
        return sum;
    }
}
