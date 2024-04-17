package LeetCode.ArrayDemo;

public class MaxResult {

    public static void main(String[] args) {
//        int[] nums = {1, -1, -2, 4, -7, 3};
//        int nums[] = {1, -1, -2, 4, -7, 3};
//
//        int k = 2;

//        int nums[] = {10, -5, -2, 4, 0, 3};
//        int k = 3;
        int nums[] = {1, -5, -20, 4, -1, 3, -6, -3};
        int k = 2;
        MaxResult maxResult = new MaxResult();
        System.out.println(maxResult.maxResult(nums, k));
    }

    public int maxResult(int[] nums, int k) {
        int max = nums[0];
        int maxLen = nums.length;
        int nextNum = 0;
        for (int i = nextNum; i < maxLen; i++) {
            int maxSum = Integer.MIN_VALUE;
            int kIndex = 0;
            for (int j = nextNum + 1; j < maxLen && kIndex < k; j++) {
                if (maxSum < nums[j] + max) {
                    maxSum = nums[j] + max;
                    nextNum = j;
                }
                kIndex++;
            }
            max = maxSum != Integer.MIN_VALUE ? maxSum : max;
        }
        return max;
    }
}
