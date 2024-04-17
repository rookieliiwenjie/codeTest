package LeetCode.ArrayDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/22 2:00 下午
 * @Description:
 */
public class MinSubArrayLenght {
    public static void main(String[] args) {
       // int nums [] = {2,3,1,2,4,3};
        //int nums [] = {1,4,4};
        int nums[] = {1, 2, 3, 4, 5};
        int target = 11;
        int i = minSubArrayLen2plus(target, nums);
        System.out.println("i = " + i);
    }

    /**
     * 如何跳动获取如何值相同的数据
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int nums[]) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int mins = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > target) {
                    break;
                }
                if (sum < target) {
                    mins++;
                }
                if (sum == target) {
                    mins++;
                    min = Math.min(min, mins);
                    break;
                }

            }
        }
        return Integer.MAX_VALUE == min ? 0 : min;

    }
    public  static  int minSubArrayLen3(int target, int[] nums) {
        int n = nums.length, ans = n + 1, s = 0, left = 0;
        for (int right = 0; right < n; ++right) {
            s += nums[right];
//            while (s - nums[left] >= target)
//                s -= nums[left++];
//            if (s >= target)
//                ans = Math.min(ans, right - left + 1);
            while (s >= target) { // 满足要求
                ans = Math.min(ans, right - left + 1);
                s -= nums[left++];
            }
        }
        return ans <= n ? ans : 0;
    }


    public static int minSubArrayLen2(int target, int nums[]) {
        int min = Integer.MAX_VALUE;
        int left = 0,right = 0;
        int sum = 0;
        while (left <= right && right <= nums.length - 1) {
            sum = sum + nums[right];
            if (sum < target) {
                right++;
            } else if (sum >= target) {
                min = Math.min(min, right - left +1);
                left++;
                right = left;
                sum=0;
            }
        }
        return Integer.MAX_VALUE == min ? 0 : min;

    }


    public static int minSubArrayLen2plus(int target, int nums[]) {
        int min = Integer.MAX_VALUE;
        int left = 0,right = 0;
        int sum = 0;
        while (left <= right && right <= nums.length - 1) {
            sum = sum + nums[right];
            if (sum < target) {
                right++;
            } else {
                min = Math.min(min, right - left +1);
                sum-=(nums[left]+nums[right]);
                left++;
            }
        }
        return Integer.MAX_VALUE == min ? 0 : min;

    }
    public static int minSubArrayLen2plus2(int target, int nums[]) {
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;
        while (left <= right && right <= nums.length - 1) {
            sum = sum + nums[right];
            while (target <= sum) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return Integer.MAX_VALUE == min ? 0 : min;

    }

    public static int minSubArrayLen2plusss(int target, int nums[]) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum+= nums[right];
            while (target<=sum){
                min = Math.min(min,right-left+1);
                sum-=nums[left--];
            }
        }
        return Integer.MAX_VALUE == min ? 0 : min;

    }
}
