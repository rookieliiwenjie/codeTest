package LeetCode.ArrayDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/7 11:06 上午
 * @Description:
 */
public class MiceAndCheese {


    public static int miceAndCheese2(int[] reword1, int[] reword2, int k) {
//        if (k >= reword1.length) {
//            return Arrays.stream(reword1).sum();
//        }

        int sortNum[][] = new int[reword1.length][2];
        int sortNum2[][] = new int[reword2.length][2];
        for (int i = 0; i < reword1.length; i++) {
            sortNum[i][0] = i;
            sortNum[i][1] = reword1[i];

        }
        for (int i = 0; i < reword2.length; i++) {
            sortNum2[i][0] = i;
            sortNum2[i][1] = reword2[i];
        }
        Arrays.sort(sortNum, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(sortNum2, Comparator.comparingInt(a -> a[1]));
        System.out.println("sortNum2 = " + sortNum2);
        System.out.println("sortNum2 = " + sortNum);
        int max = 0;
        int num1index = sortNum.length - 1;
        int num2index = sortNum.length - 1;
        //这里有一个点，就是我如何获取最大
        List<Integer> list = new ArrayList<>(k);
        while (num1index >= 0 && k >= 0) {
            if (sortNum[num1index][1] > sortNum2[num2index][1] && !list.contains(sortNum[num1index][0])) {
                list.add(sortNum[num1index][0]);
                num1index++;
                k--;
                max += sortNum[num1index][1];
            } else if (num2index <= 0 && sortNum[num1index][1] < sortNum2[num2index][1] && !list.contains(sortNum2[num2index][0])) {
                list.add(sortNum2[num2index][0]);
                num2index++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] rq = {4, 1, 5, 3, 3};
        int[] rq2 = {3, 4, 4, 5, 2};
        int k = 2;
        miceAndCheese(rq, rq2, k);
    }

    public static int miceAndCheese(int[] reward1, int[] reward2, int k) {
//        if (k >= reword1.length) {
//            return Arrays.stream(reword1).sum();
//        }
        int leght = reward1.length;
        //贪心默认都让第二只鸭迟到了
        int secondDuckSum = 0;
        int diff[] = new int[leght];
        for (int i = 0; i < leght; i++) {
            secondDuckSum += reward2[i];
            diff[i] = reward1[i] - reward2[i];
        }
        //diff[i] =  reward1[i] - reward2[i] 所以 secondDuckSum = reward2[i] + reward1[i] - reward2[i] ======    secondDuckSum = reward1[i]
        //[1, -3, 1, -2, 1]
        quickSortDemo(diff, 0, diff.length - 1);
        for (int i = leght - 1; i >= leght - k; i--) {
            secondDuckSum += diff[i];
        }
        //排序
        return secondDuckSum;
    }
    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int base = arr[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (arr[j] >= base && i < j) {
                j--;
            }
            while (arr[i] <= base && i < j) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[i];
        arr[i] = base;
        sort(arr, left, i - 1);
        sort(arr, i + 1, right);
    }
    public static void quickSort(int arr[], int left, int right) {
        if (left > right) {
            return;
        }
        int curIndex = arr[left];
        int leftIndex = left;
        int rightindx = right;
        while (leftIndex < rightindx) {
            while (leftIndex < rightindx && arr[leftIndex] <= curIndex) {
                leftIndex++;
            }
            while (leftIndex < rightindx && arr[rightindx] >= curIndex) {
                rightindx--;
            }
            int temp = arr[leftIndex];
            arr[leftIndex] = arr[rightindx];
            arr[rightindx] = temp;
        }
        arr[left] = arr[leftIndex];
        arr[leftIndex] = curIndex;
        quickSort(arr, left, leftIndex - 1);
        quickSort(arr, leftIndex + 1, right);
    }

    /**
     * 错误版本
     * @param arr
     * @param start
     * @param end
     */
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
        if (left-1 > start) {
            quickSortDemo(arr, start, left - 1);
        }
        if (right+1 < end) {
            quickSortDemo(arr, right + 1, end);
        }

    }

    static void QuickSort2(int arr[], int start, int end) {
        if (start >= end)
            return;
        int i = start;
        int j = end;
        // 基准数
        int baseval = arr[start];
        while (i < j) {
            // 从右向左找比基准数小的数
            while (i < j && arr[j] >= baseval) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            // 从左向右找比基准数大的数
            while (i < j && arr[i] < baseval) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        // 把基准数放到i的位置
        arr[i] = baseval;
        // 递归
        QuickSort2(arr, start, i - 1);
        QuickSort2(arr, i + 1, end);
    }

}
