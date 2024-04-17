package com.company.Java.daili.dtProxy.jdkDail;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/15 8:10 下午
 * @Description:
 */
public class Sort {
    public static void main(String[] args) {

    }

    public static void quickSort(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int pre = arr[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (arr[left] <= pre) {
                left++;
            }
            if(left<right){
                arr[left] = arr[right];
            }
            while (arr[right] >= pre) {
                right--;
            }
        }
        arr[left] = pre;
        quickSort(arr, left - 1, end);
        quickSort(arr, start, right + 1);
    }
}
