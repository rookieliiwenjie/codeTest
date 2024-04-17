package com.company.sortDemo;

import java.util.Arrays;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/31 11:29 上午
 * @Description: 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
//        System.out.println("排序之前：");
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//        int aa[] = {3, 2};
       shellSort(array);
        //shellSort(array);
       myShellSort();
    }
    public static void myShellSort() {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int gap = arr.length;
        while (gap > 1) {
            gap = gap / 2;
            //划分的组
            for (int i = gap; i < arr.length; i += gap) {
                int k = i - gap;
                while (k >= 0 && arr[k] > arr[k + gap]) {
                    int temp = arr[k];
                    arr[k] = arr[k + gap];
                    arr[k + gap] = temp;
                    k = k - gap;
                }
            }
        }
        System.out.println("arr = " + arr);
    }

    public static void myShellSort2() {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        int gap = arr.length;
        while (gap > 1) {
            gap = gap / 2;
            //划分的组
            for (int i = gap; i < arr.length; i += gap) {
                int k = i - gap;
                while (k >= 0 && arr[k] > arr[k + gap]) {
                    int temp = arr[k];
                    arr[k] = arr[k + gap];
                    arr[k + gap] = temp;
                    k = k - gap;
                }
            }
        }
        System.out.println("arr = " + arr);
    }
    public static void shellSort(int array[]) {
        //希尔排序
        int gap = array.length;
        while (gap > 1) {
            //增量每次减半
            gap /= 2;
            //划组 相隔为gap的两个数进行交换
            System.out.println("--==========gap = " + gap + "---========-");
            //感觉这里有问题
            for (int i = 0; i < gap; i++) {
                System.out.println("--------i = " + i + "-----------");
                //这个循环里其实就是一个插入排序
                for (int j = i + gap; j < array.length; j += gap) {
                    System.out.println("j = " + j);
                    int k = j - gap;
                    System.out.println("k = " + k);
                    while (k >= 0 && array[k] > array[k + gap]) {
                        System.out.println(" while k = " + k);
                        int temp = array[k];
                        array[k] = array[k + gap];
                        array[k + gap] = temp;
                        k -= gap;
                    }
                }
            }
            System.out.println(" ---------");
//            if (gap == 1) {
//                break;
//            }
        }

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    //希尔排序
    public static void shellSort2(int[] arr) {
        //遍历所有的步长
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            //遍历所有的元素
            for (int i = gap; i < arr.length; i++) {
                //遍历本组中所有元素
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //打印每次排序后的结果
            System.out.println(Arrays.toString(arr));
        }
    }


}
