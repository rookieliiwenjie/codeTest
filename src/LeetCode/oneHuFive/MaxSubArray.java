package LeetCode.oneHuFive;

public class MaxSubArray {
    public static void main(String[] args) {
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArray maxSubArray = new MaxSubArray();
        maxSubArray.maxSubArray(nums);
    }

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

    public int maxSubArray2(int[] nums) {
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
