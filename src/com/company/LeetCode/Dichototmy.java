package com.company.LeetCode;

import java.util.Collections;

/**
 * @Author: wenjie.li
 * @Date: 2023/4/10 9:37 上午
 * @Description:
 */
public class Dichototmy {
    public static void main(String[] args) {
        int arr[]={1,2,3,5,7,9,20};
        int target = 3;
        System.out.println("dichotomy(arr,target) = " + dichotomy(arr,target));
    }

    public static int dichotomy(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        if (arr.length <= 0) {
            return -1;
        }
        if (arr.length == 1) {
            return target == arr[0] ? arr[0] : target;
        }
        
        while (left <= right) {
            int mod = left + right / 2;
            if (arr[mod] < target) {
                left = mod+1;
            } else if (arr[mod] > target) {
                right = mod-1;
            } else {
                index = mod;
                break;
            }
        }
        return index;

    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

}
