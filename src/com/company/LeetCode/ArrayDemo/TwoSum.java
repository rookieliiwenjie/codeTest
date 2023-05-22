package com.company.LeetCode.ArrayDemo;/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-10-12 16:39
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 14};

//        System.out.println("nums = " + twoSum(nums, 25));
//        System.out.println("nums2 = " + twoSum2(nums, 25));
        System.out.println("nums2 = " + onStartup(nums, 25));

    }

    public static int[] twoSum(int[] nums, int target) {
        int newnums[] = new int[2];
        int i = 0;
        int j = 1;
        while (j <= nums.length && i <= nums.length - 1) {
            if (j == nums.length) {
                i++;
                j = i + 1;
            }
            if (nums[i] + nums[j] == target) {
                break;
            }
            j++;
        }
        newnums[0] = nums[i];
        newnums[1] = nums[j];
        return newnums;
    }


    public static int[] twoSum2(int[] nums, int target) {
        int newNums[] = new int[2];
        int i = 0;
        int j = 1;
        while (i < nums.length || j < nums.length) {
            if(j==nums.length){
                i++;
                j=i+1;
            }
            if ( (nums[i] + nums[j]) < target) {
                j++;
            } else if ((nums[i] + nums[j]) > target) {
                i++;
            } else {
                newNums[0] = i;
                newNums[1] = j;
                break;
            }
        }
        return newNums;
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        int newNums[] = new int[2];
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left + (right-left)/2;
//            if(){
//
//            }

        }
        return newNums;
    }

    public static int[] onStartup(int[] nums, int target) {
        int newNums[] = new int[2];
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            if(nums[left]+nums[right]<target){
                left++;
            }else if(nums[left]+nums[right]>target){
                right--;
            }else {
                newNums[0] = left;
                newNums[1] = right;
                break;
            }

        }
        return newNums;
    }

//    public static int[] twoSumTwo(int[] nums, int target) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int num : nums) {
//
//        }
//    }

}
