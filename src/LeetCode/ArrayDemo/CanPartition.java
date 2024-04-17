package LeetCode.ArrayDemo;

import java.util.Arrays;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/31 8:59 下午
 * @Description:
 */
public class CanPartition {
    public static void main(String[] args) {
        //int arr[] ={1,3,4,4};
        int arr[] ={2,2,1,1};
        System.out.println("arr = " + canPartition(arr));
    }

    public static boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int leftSum = nums[left];
        int rightSum = nums[right];
        while (left < right) {
            while (left<right && leftSum < rightSum) {
                left++;
                leftSum += nums[left];

            }
            while (left<right && leftSum > rightSum) {
                right--;
                rightSum += nums[right];
            }
            if(right-left==1){
               return true;
            }else {
                if(++left<right){
                    leftSum += nums[left];
                }
            }
        }
        return false;
    }
}
