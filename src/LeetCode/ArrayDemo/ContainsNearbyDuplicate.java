package LeetCode.ArrayDemo;

import java.util.*;

public class ContainsNearbyDuplicate {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
     * 满足 nums[i] == nums[j] 且 abs(i- j) <= k 。
     * 如果存在，返回 true ；否则，返回 false 。
     * 
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean flag = false;
        HashMap<Integer, Integer> indexAndSum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexAndSum.containsKey(nums[i])) {
                int index = indexAndSum.get(nums[i]);
                int sum = Math.abs(index - i);
                if (sum <= k) {
                    return true;
                }
            }
            indexAndSum.put(nums[i], i);
        }
        return flag;

    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate containsNearbyDuplicate = new ContainsNearbyDuplicate();
        // [1,2,1]
        int[] nums = { 1, 2, 1 };
        int k = 0;
        boolean b = containsNearbyDuplicate.containsNearbyDuplicate2(nums, k);
        System.out.println(b);
    }

    /**
     * 滑动窗口
     * [1,2,1]
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        // [1,2,3,1,2,3]
        // k =2
        Set<Integer> nowNums = new HashSet<>();
        int bing = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nowNums.contains(nums[i])) {
                return true;
            }
            nowNums.add(nums[i]);
            if ((i - bing) >= k) {
                nowNums.remove(nums[bing]);
                bing++;
            }
        }
        return false;

    }

    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}
