package com.company.sortDemo.Quick;

import java.util.Arrays;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/11 7:14 下午
 * @Description:
 */
public class QuickSort {
    public static void quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 9, 1, 3, 6};
        System.out.println("Original array: " + Arrays.toString(nums));
        quickSort(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));
    }
}

