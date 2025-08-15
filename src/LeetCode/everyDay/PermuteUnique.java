package LeetCode.everyDay;

import java.util.*;

/**
 * 全排列
 */
public class PermuteUnique {
    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */
    //如何处理重复的数据
    //全排列如何处理
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, path, used, result);
        return new ArrayList<>(result);
    }
    public void backtrack(int[] nums, List<Integer> current, boolean[] used, Set<List<Integer>> result){
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // 存入新副本避免后续修改影响结果
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // 跳过已使用的元素
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, current, used, result); // 递归生成下一位置
            current.remove(current.size() - 1); // 回溯
            used[i] = false;
        }
    }

    public static void main(String[] args) {

    }

    boolean[] vis;

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack2(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack2(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack2(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }

}
