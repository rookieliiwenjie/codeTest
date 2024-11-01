package LeetCode;

/**
 * 在此填写类的用途、注意事项等
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 * 提示：
 * 1 <=arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * @see https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for (int x : nums) {
            //如果小于那么就跳过。
            pre = Math.max(pre + x, x);
            max = Math.max(pre, max);
        }
        return max;
    }
}
