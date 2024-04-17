package LeetCode;

import java.util.HashMap;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/5 7:22 下午
 * @Description:
 */
public class SingleNumber {
//    public static int[] singleNumber(int[] nums) {
////        int a = 0, b = 0;
////        for (int i = 0; i < nums.length; i++) {
////
////        }
////        return new int[]{a, b};
//        int nums [] = {2,2,3,2};
//    }

    public static void main(String[] args) {
        int nums [] = {2,2,3,2};
    }

    public int[] twoNums(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] newNums = new int[2];
        while (left <= right) {
            int sumNum = nums[left] + nums[right];
            if (sumNum < target) {
                left++;
            } else if (sumNum > target) {
                right--;
            } else {
                newNums[0] = nums[left];
                newNums[1] = nums[right];
                break;
            }
        }
        return newNums;
    }

    public static  int twoNums2(int nums[]) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : hashMap.keySet()) {
            if (hashMap.get(key) == 1) {
                return key;

            }
        }
        return 0;
    }
}
