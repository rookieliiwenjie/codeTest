package com.company.sortDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/24 4:35 下午
 * @Description: 选择排序 ，每次都获取最大或者最小的数和索引，结算内部循环后，将对应数据插入 对应锁定，每次内循环 移动一个数据。
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 7, 9};
        selectionSortPlus(arr);
    }

    public static int[] selectionSort(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = min;
                    min = arr[i];
                }
            }
            System.out.println("arr = " + arr);
        }
        return arr;
    }

    public static int[] selectionSortPlus(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = min;
            System.out.println("arr = " + arr);
        }
        return arr;
    }

    public void selectSort() {
        int arr[] = {6, 5, 3, 2, 4};

        //选择
        for (int i = 0; i < arr.length; i++) {
            //默认第一个是最小的。
            int min = arr[i];
            //记录最小的下标
            int index = i;
            //通过与后面的数据进行比较得出，最小值和下标
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            //然后将最小值与本次循环的，开始值交换
//            int temp = arr[i];
//            arr[i] = min;
//            arr[index] = temp;

            arr[index] = arr[i];
            arr[i] = min;
            //说明：将i前面的数据看成一个排好的队列，i后面的看成一个无序队列。每次只需要找无需的最小值，做替换
        }
    }
}
