package com.company.LeetCode;

import com.company.SingleonDemo.A;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator.OfInt;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * @author rookie.li
 * @date 2021-09-16 16:11
 */
public class GetLeastNumbers {

    /*public int[] getLeastNumbers(int[] arr, int k) {
        int[] leastNumberArr = new int[k];
        for (int i = 0; i < arr.length; i++) {

        }
    }
*/
    public static void main(String[] args) {
        int arr[] = new int[]{1, 4, 0, 7, 2};
        int[] leastNumbers1 = getLeastNumbers1(arr, 3);
        for (int i :
                leastNumbers1) {
            System.out.print(i + ",");

        }
    }

    /**
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers1(int[] arr, int k) {
        if (arr.length < k || k <= 0) {
            return new int[0];
        }
        Arrays.sort(arr);
        int[] spliterator = Arrays.copyOf(arr, k);
        return spliterator;
    }

    public void quickSort(int arr[]){

    }
}
