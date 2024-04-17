package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/13 3:47 下午
 * @Description:
 */
public class FindMaxK {
    public static void main(String[] args) {
        int arr[] = {-1,10,6,7,-7,1};
        findMaxK2(arr);
    }

    public static int findMaxK(int nums[]) {
        Set<Integer> numsSet = new HashSet<>();
        int max = -1;
        for (int num : nums) {
            numsSet.add(num);
        }
        for (int num : numsSet) {
            if (numsSet.contains(-num)) {
                max = Math.max(max, num);
            }
        }
        return max;

    }
    public static int findMaxK2(int nums[]) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
         while (left<=right){
             if(-nums[left]<nums[right]){
                 right--;
             }else if(-nums[left]>nums[right]){
                 left++;
             }else {
                 return nums[right];
             }
         }
         return -1;
    }
}
