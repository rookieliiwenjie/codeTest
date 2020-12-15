package com.company.LeetCode;

/**
 * Created by lwj32 on 2020/6/27.
 */
public class MaxArea {
    public static void main(String[] args) {
        int arr[]={1,8,6,2,5,4,8,3,7};
        System.out.println("maxArea(arr) = " + maxArea(arr));
    }
    public static int maxArea(int[] height) {
        int r = height.length-1;
        int l = 0;
        int maxArea = 0;
        while (l<r){
            int area = Math.min(height[l],height[r])*(r-l);
            maxArea = Math.max(area,maxArea);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }

        }
        return maxArea;
    }
}
