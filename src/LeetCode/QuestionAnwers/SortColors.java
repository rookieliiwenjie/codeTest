package LeetCode.QuestionAnwers;

import java.util.HashMap;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，
 * 原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 */
public class SortColors {
    public static void main(String[] args) {
        int nums []={1,2,0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        int newNumIndex = 0;
        for (int i = 0; i < 3; i++) {
            if (hashMap.containsKey(i)) {
                for (int j = 1; j <= hashMap.get(i); j++) {
                    nums[newNumIndex] = i;
                    newNumIndex++;
                }
            }
        }
    }

}
