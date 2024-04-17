package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wenjie.li
 * @Date: 2023/4/13 10:52 下午
 * @Description: 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 * <p>
 * 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
 */
public class MostFrequentEven {
    public static void main(String[] args) {
        int nums[] = {0,1,2,2,4,4,1};
        System.out.println("mostFrequentEven(nums) = " + mostFrequentEven(nums));
    }

    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> treeMap = new HashMap<Integer, Integer>();
        for (int j : nums) {
            if (j % 2 == 0) {
                treeMap.put(j, treeMap.getOrDefault(j, 0) + 1);
            }
        }
        if(treeMap.size()<1){
            return -1;
        }
        int num =Integer.MAX_VALUE;
        int sum = Integer.MIN_VALUE;
        /**
         * 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
         *
         * 如果存在多个满足条件的元素，只需要返回 最小 的一个。
         * 首先是频繁
         */
        for (Integer key : treeMap.keySet()) {
            if (sum <= treeMap.get(key)) {
                if (sum == treeMap.get(key) && key > num) {
                    continue;
                }
                num = key;
                sum = treeMap.get(key);
            }
        }
        return num;
    }
}
