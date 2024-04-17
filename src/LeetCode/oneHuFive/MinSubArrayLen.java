package LeetCode.oneHuFive;

import com.company.Main;

public class MinSubArrayLen {
    public static void main(String[] args) {
//        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
//        int nums[] = {2, 3, 1, 2, 4, 3};
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
//        int nums[] = {1,1,1,1,1,1,1,1};
        int nums[] = {1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen.minSubArrayLen(11, nums));
        System.out.println(minSubArrayLen.hasSubarray(nums,11 ));
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    /**
     * 最小连续子数组长度 大于或者等于target
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int nums[]) {
        int sum = 0;
        if (nums == null || nums.length == 0) {
            return sum;
        }
        sum = Integer.MAX_VALUE;
        int begin = 0;
        int end = 0;
        int numLen = nums.length-1;
        int sumNum = 0;
        while (begin <= numLen && end <=numLen) {
            sumNum += nums[end];
            if (sumNum >= target) {
                sum = Math.min(sum, end - begin);
                sumNum = sumNum-nums[begin];
                begin++;
            }
            end++;
        }
        return sum == Integer.MAX_VALUE ? 0 : sum;
    }




    public static boolean hasSubarray(int[] nums, int target) {
        int start = 0;
        int sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum > target) {
                sum -= nums[start];
                start++;
            }
            if (sum == target) {
                return true;
            }
        }
        return false;
    }
}
