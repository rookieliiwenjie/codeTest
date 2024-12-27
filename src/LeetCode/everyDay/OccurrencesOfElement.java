package LeetCode.everyDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OccurrencesOfElement {
    /**
     * 给你一个整数数组 nums ，一个整数数组 queries 和一个整数 x 。
     * <p>
     * 对于每个查询 queries[i] ，你需要找到 nums 中第 queries[i] 个 x 的位置，
     * 并返回它的下标。如果数组中 x 的出现次数少于 queries[i] ，该查询的答案为 -1 。
     * 请你返回一个整数数组 answer ，包含所有查询的答案。
     * 示例 1：
     * 输入：nums = [1,3,1,7], queries = [1,3,2,4], x = 1
     * 输出：[0,-1,2,-1]
     * 解释：
     * 第 1 个查询，第一个 1 出现在下标 0 处。
     * 第 2 个查询，nums 中只有两个 1 ，所以答案为 -1 。
     * 第 3 个查询，第二个 1 出现在下标 2 处。
     * 第 4 个查询，nums 中只有两个 1 ，所以答案为 -1 。
     * 示例 2：
     * 输入：nums = [1,2,3], queries = [10], x = 5
     * 输出：[-1]
     * 解释：
     * 第 1 个查询，nums 中没有 5 ，所以答案为 -1 。
     * 提示：
     * 1 <= nums.length, queries.length <= 105
     * 1 <= queries[i] <= 105
     * 1 <= nums[i], x <= 104
     *
     * @param nums
     * @param queries
     * @param x
     * @return
     */

    /**
     * 比较low的版本
     *
     * @param nums
     * @param queries
     * @param x
     * @return
     */
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int numIndex = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                hashMap.put(numIndex, i);
                numIndex++;
            }
        }
        int res[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = hashMap.getOrDefault(queries[i], -1);
        }
        return res;
    }

    /**
     * 稍微提升
     * @param nums
     * @param queries
     * @param x
     * @return
     */
    public int[] occurrencesOfElement2(int[] nums, int[] queries, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                list.add(i);
            }
        }
        int res[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int z = queries[i];
            if (list.size() >= z) {
                res[i] = list.get(z - 1);
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}
