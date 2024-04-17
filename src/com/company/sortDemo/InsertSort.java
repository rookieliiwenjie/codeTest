package com.company.sortDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/24 4:59 下午
 * @Description: 插入排序
 */
public class InsertSort {

    public static void insertSort() {
        int arr[] = {3, 4, 7, 8, 9, 1, 2};
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public static void insertSort2() {
        int arr[] = {3, 4, 7, 8, 9, 1, 2};
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 7, 8, 9, 1, 2};
         insertTest(arr);

        System.out.println("arr = " + arr);
    }

    public static void insertFuxi(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("arr = " + arr);
    }


    public static void insertTest(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i + 1;
            while (k > 0) {
                if (arr[k] < arr[k - 1]) {
                    int temp = arr[k - 1];
                    arr[k - 1] = arr[k];
                    arr[k] = temp;
                }
                k--;
            }
        }
    }
}
