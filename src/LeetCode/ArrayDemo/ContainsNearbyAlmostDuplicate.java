package LeetCode.ArrayDemo;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;


public class ContainsNearbyAlmostDuplicate {
    /**
     * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
     * 找出满足下述条件的下标对 (i, j)：
     * i != j,
     * abs(i - j) <= indexDiff
     * abs(nums[i] - nums[j]) <= valueDiff
     * 如果存在，返回 true ；否则，返回 false 。
     *
     * @param nums
     * @param indexDiff
     * @param valueDiff
     * @return
     */
    /**
     * 滑动窗口
     * 维护一个indexDiff的窗口
     * 判断窗口内的所有参数
     *
     * @param nums
     * @param indexDiff
     * @param valueDiff
     * @return abs(i - j) <= indexDiff
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        List<Integer> valueList = new ArrayList<>();
        int bing = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i - bing) > indexDiff) {
                valueList.remove(0);
                bing++;
            }
            for (int j = 0; j < valueList.size(); j++) {
                if (Math.abs(valueList.get(j) - nums[i]) <= valueDiff) {
                    return true;
                }
            }
            valueList.add(nums[i]);


        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int indexDiff, int valueDiff) {
        //x = 数 y = 下标
        int[][] num = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            num[i][0] = nums[i];
            num[i][1] = i;
        }
        Arrays.sort(num, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(num[i][1] - num[j][1]) <= indexDiff && Math.abs(num[i][0] - num[j][0]) <= valueDiff) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate containsNearbyAlmostDuplicate = new ContainsNearbyAlmostDuplicate();
        int[] nums = {1, 5, 9, 1, 5, 9};
        int indexDiff = 2;
        int valueDiff = 3;
        boolean b = containsNearbyAlmostDuplicate.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);
        System.out.println(b);
    }
    /**
     * * 示例 1：
     * 输入：nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
     * 输出：true
     * 解释：可以找出 (i, j) = (0, 3) 。
     * 满足下述 3 个条件：
     * i != j --> 0 != 3
     * abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
     * abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
     */

}
