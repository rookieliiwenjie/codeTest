package com.company.sortDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/26 3:06 下午
 * @Description: 分治法 和 挖坑填数法
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {23, 4, 23, 71, 3, 11, 59};
        quickSortDemo2(arr, 0, arr.length - 1);
        System.out.println("arr = " + arr);
    }

    public static void quickSortDemo(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int pre = arr[start];
        while (left < right) {
            while (left < right && pre < arr[right]) {
                right--;
            }
            while (left < right && pre > arr[left]) {
                left++;
            }
            if (arr[left] == arr[right]) {
                left++;
            } else {
                int tem = arr[right];
                arr[right] = arr[left];
                arr[left] = tem;
            }
        }
        if (left > start) {
            quickSortDemo(arr, start, left - 1);
        }
        if (right < end) {
            quickSortDemo(arr, right + 1, end);
        }

    }


    public static void quickSortDemo2(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int pre = arr[start];
        while (left < right) {
            while (left < right && pre > arr[right]) {
                right--;
            }
            while (left < right && pre < arr[left]) {
                left++;
            }
            if (arr[left] == arr[right]) {
                left++;
            } else {
                int tem = arr[right];
                arr[right] = arr[left];
                arr[left] = tem;
            }
        }
        if (left - 1 > start) {
            quickSortDemo2(arr, start, left - 1);
        }
        if (right + 1 < end) {
            quickSortDemo2(arr, right + 1, end);
        }

    }

}
