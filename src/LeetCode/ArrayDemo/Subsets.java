package LeetCode.ArrayDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/12 2:59 下午
 * @Description:
 */
public class Subsets {
    public static void main(String[] args) {

    }

    static List<List<Integer>> list = new ArrayList<>();

    /**
     * 1。变化顺序的如何处理 这个不同考虑因为顺序不同的也不行
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
          //  recusion(i, nums);
            list.add(Collections.singletonList(nums[i]));
        }
        return list;
    }

    public static void recusion(int index, int nums[], List<Integer> oldList) {
        List<Integer> newList = oldList;
        for (int i = index; i < nums.length; i++) {
            newList.add(nums[i]);
            list.add(newList);
            recusion(i, nums, newList);
        }
        list.add(newList);
    }

}
