package com.company.LeetCode.day_07_2021_06_01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lwj32 on 2021/6/1.
 */
public class IsStraight {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int flag = 0;
        for (int i= 0;i<nums.length-1;i++){
            if(nums[i] ==0){
               flag++;
            }else if(nums[i]==nums[i+1]){
                return  false;
            }
        }
        return nums[nums.length-1] - nums[flag] <5;
    }
}
