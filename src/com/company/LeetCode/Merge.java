package com.company.LeetCode;

/**
 * @Author: wenjie.li
 * @Date: 2023/4/26 10:17 下午
 * @Description: 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1p = 0;
        int num2p  =0;
        int[] sorted = new int[m + n];
        while (num1p<m  || num2p < n){
            if(num1p==m){
                sorted[m+num2p]= nums2[num2p++];
            }else if(num2p==n){
                sorted[n+num1p]= nums1[num1p++];
            }else if(nums1[num1p]>nums2[num2p]){
                sorted[num1p+num2p] = nums2[num2p++];
            }else {
                sorted[num1p+num2p] = nums1[num1p++];
            }
        }
        for (int i = 0; i < sorted.length; i++) {
            nums1[i] = sorted[i];
        }
    }
}
