package LeetCode.everyDay;

/**
 * 2044. 统计按位或能得到最大值的子集数目
 * 中等
 * 提示
 * 给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的
 * 不同非空子集的数目 。
 * <p>
 * 如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。
 * 如果选中的元素下标位置不一样，则认为两个子集 不同 。
 * <p>
 * 对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 */

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 或 | 每一为 有1 就为1
 * 输入：nums = [3,1]
 * 输出：2
 * 解释：子集按位或能得到的最大值是 3 。有 2 个子集按位或可以得到 3 ：
 * - [3]
 * - [3,1]
 * 示例 2：
 * 输入：nums = [2,2,2]
 * 输出：7
 * 解释：[2,2,2] 的所有非空子集的按位或都可以得到 2 。总共有 23 - 1 = 7 个子集。
 * 示例 3：
 *
 * 输入：nums = [3,2,1,5]
 * 输出：6
 * 解释：子集按位或可能的最大值是 7 。有 6 个子集按位或可以得到 7 ：
 * - [3,5]
 */
public class CountMaxOrSubsets {
    static Map<Integer, Integer> orCount = new HashMap<>();
    //Dp状态压缩
    public static int countMaxOrSubsets(int[] nums) {
        orCount.put(0,1);
        for (int num : nums) {
            Map<Integer, Integer> newMap = new HashMap<>(orCount);
            for (int orVal : orCount.keySet()) {
                int newOr = orVal | num;
                newMap.put(newOr, newMap.getOrDefault(newOr, 0) + orCount.get(orVal));
            }
            orCount = newMap;
        }
        int maxOr = Collections.max(orCount.keySet());
        int count = orCount.get(maxOr);
        return count;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new  Solution2();
        int nums[] = {3,2,1,5};
//        solution2.countMaxOrSubsets(nums);
        countMaxOrSubsets(nums);

    }
    static class Solution2 {
        private int maxOr = 0;
        private int count = 0;
        public int countMaxOrSubsets(int[] nums) {
            backtrack(nums, 0, 0);
            return count;
        }


        private void backtrack(int[] nums, int index, int currentOr) {
            //退出条件
            if (index == nums.length) {
                if (currentOr == maxOr) {
                    count++;
                } else if (currentOr > maxOr) {
                    maxOr = currentOr;
                    count = 1;
                }
                return;
            }

            // 选择当前元素
            backtrack(nums, index + 1, currentOr | nums[index]);
            // 不选择当前元素
            backtrack(nums, index + 1, currentOr);
        }
    }
}
