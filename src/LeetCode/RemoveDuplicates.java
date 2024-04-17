package LeetCode;

/**
 * @Author: wenjie.li
 * @Date: 2023/4/26 11:06 下午
 * @Description:
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int nums[] = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println("nums = " + removeDuplicates2(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int legnt = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur != nums[i]) {
                cur = nums[i];
                nums[legnt] = cur;
                legnt++;
            }
        }
        return legnt;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int legnt = 1;
        int cur = nums[0];
        int sum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cur != nums[i]) {
                cur = nums[i];
                nums[legnt] = cur;
                legnt++;
                sum = 1;
            } else if (cur == nums[i]) {
                if (sum < 2) {
                    cur = nums[i];
                    nums[legnt] = cur;
                    legnt++;
                }
                sum++;
            }
        }
        return legnt;
    }

    public int removeDuplicates3(int[] nums) {
        return process(nums, 2);
    }

    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            if (u < k || nums[u - k] != x) {
                nums[u++] = x;
            }
        }
        return u;
    }

}
