package com.company.LeetCode;

/**
 * Created by lwj32 on 2020/6/27.
 */
public class FristMissingProitvie {
    public static void main(String[] args) {
        int arr []={1,2,0};
        System.out.println("arr = " + firstMissingPositive(arr));
    }
    public static  int firstMissingPositive(int[] nums) {

        //将所有的负数 ， 0， 都替换为1
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<=0){
                nums[i]=nums.length+1;
            }
        }
        //将出现过数对应下标的数替换为负数证明这个数出现过了
        for(int i =0;i<nums.length;i++){
            if(nums[i]<nums.length){
                nums[nums[i]]=-nums[i];
            }

        }
        for(int i = 0;i<nums.length;++i){
            if(nums[i]>0){
               return i+1;
            }

        }
        return nums.length+1;
    }

}
