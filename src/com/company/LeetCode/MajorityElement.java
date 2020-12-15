package com.company.LeetCode;

import java.util.HashMap;

/**
 * @Author rookie.li
 * @create 2020/11/6
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {1};
        int i = majorityElement(arr);
        System.out.println("i = " + i);
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);

            } else {
                hashMap.put(num, 1);
            }
            if (hashMap.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }
    public int majorityElement2(int[] nums) {
        // 初始化
        int x = nums[0];
        int votes = 0;
        // 遍历
        for(int num : nums){
            if(votes == 0){
                x = num;
            }
            if(num == x){
                votes ++;
            }else{
                votes --;
            }
        }
        return x;
    }
}
