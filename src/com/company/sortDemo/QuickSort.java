package com.company.sortDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/26 3:06 下午
 * @Description: 分治法 和 挖坑填数法
 */
public class QuickSort {
    public static void main(String[] args) {
//        int arr[] = {32, 4, 23, 71, 3, 11, 59};
        int arr[] = {1, -3, 1, -2, 1};
        doublePointerSwap(arr, 0, arr.length - 1);
        System.out.println("arr = " + arr);
    }

    public static void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    static void QuickSort2(int arr[], int start, int end) {
        if (start >= end)
            return;
        int i = start;
        int j = end;
        // 基准数
        int baseval = arr[start];
        while (i != j) {
            // 从右向左找比基准数小的数
            while (i < j && arr[j] >= baseval) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            // 从左向右找比基准数大的数
            while (i < j && arr[i] <= baseval) {
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

    // {32, 4, 23, 71, 3, 11, 59};
    // 缺少數字错误版本
    public static void quickSortDemo3(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int left = start;
        int right = end;
        int pre = arr[start];
        while (left < right) {
            while (left < right && pre <= arr[right]) {
                right--;
            }
            //这里有个可怕的问题那就是不能等于，更加可怕是丢参数
            while (left < right && pre > arr[left]) {
                left++;
            }
            int tem = arr[right];
            arr[right] = arr[left];
            arr[left] = tem;
        }
        arr[start] = arr[left];
        arr[left] = pre;
        quickSortDemo3(arr, start, left - 1);
        quickSortDemo3(arr, left + 1, end);

    }

    /**
     * 错误范本 棧溢出
     *
     * @param arr
     * @param start
     * @param end
     */
    // {32, 4, 23, 71, 3, 11, 59};
    public static void quickSortDemo2(int[] arr, int start, int end) {
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
        if (left - 1 > start) {
            quickSortDemo2(arr, start, left - 1);
        }
        if (right + 1 < end) {
            quickSortDemo2(arr, right + 1, end);
        }

    }

    /**
     * 正确版本
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSortDemo(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int pre = arr[start];
        while (left < right) {
            while (left < right && pre <= arr[right]) {
                right--;
            }
            if(left<right){
                arr[left] = arr[right];
            }
            while (left < right && pre >= arr[left]) {
                left++;
            }
            if(left<right){
                arr[right] = arr[right];
            }
        }
        arr[left] = pre;
        if (left - 1 > start) {
            quickSortDemo(arr, start, left - 1);
        }
        if (right + 1 < end) {
            quickSortDemo(arr, right + 1, end);
        }

    }

    /**
     * 双边指针（交换法）
     * 思路：
     * 记录分界值 pivot，创建左右指针（记录下标）。
     * （分界值选择方式有：首元素，随机选取，三数取中法）
     *
     * 首先从右向左找出比pivot小的数据，
     * 然后从左向右找出比pivot大的数据，
     * 左右指针数据交换，进入下次循环。
     *
     * 结束循环后将当前指针数据与分界值互换，
     * 返回当前指针下标（即分界值下标）
     */
    private static int doublePointerSwap(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int leftPoint = startIndex;
        int rightPoint = endIndex;

        while (leftPoint < rightPoint) {
            // 从右向左找出比pivot小的数据
            while (leftPoint < rightPoint
                    && arr[rightPoint] > pivot) {
                rightPoint--;
            }
            // 从左向右找出比pivot大的数据
            while (leftPoint < rightPoint
                    && arr[leftPoint] <= pivot) {
                leftPoint++;
            }
            // 没有过界则交换
            if (leftPoint < rightPoint) {
                int temp = arr[leftPoint];
                arr[leftPoint] = arr[rightPoint];
                arr[rightPoint] = temp;
            }
        }
        // 最终将分界值与当前指针数据交换
        arr[startIndex] = arr[rightPoint];
        arr[rightPoint] = pivot;
        // 返回分界值所在下标
        return rightPoint;
    }


    /**
     * 双边指针（挖坑法）
     * 思路：
     * 创建左右指针。
     * 记录左指针数据为分界值 pivot，
     * 此时左指针视为"坑"，里面的数据可以被覆盖。
     *
     * 首先从右向左找出比pivot小的数据，
     * 找到后立即放入左边坑中，当前位置变为新的"坑"，
     * 然后从左向右找出比pivot大的数据，
     * 找到后立即放入右边坑中，当前位置变为新的"坑"，
     *
     * 结束循环后将最开始存储的分界值放入当前的"坑"中，
     * 返回当前"坑"下标（即分界值下标）
     */
    private  static  int doublePointerHole(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int leftPoint = startIndex;
        int rightPoint = endIndex;

        while (leftPoint < rightPoint) {
            // 从右向左找出比pivot小的数据，
            while (leftPoint < rightPoint
                    && arr[rightPoint] > pivot) {
                rightPoint--;
            }
            // 找到后立即放入左边坑中，当前位置变为新的"坑"
            if (leftPoint < rightPoint) {
                arr[leftPoint] = arr[rightPoint];
                leftPoint++;
            }
            // 从左向右找出比pivot大的数据
            while (leftPoint < rightPoint
                    && arr[leftPoint] <= pivot) {
                leftPoint++;
            }
            // 找到后立即放入右边坑中，当前位置变为新的"坑"
            if (leftPoint < rightPoint) {
                arr[rightPoint] = arr[leftPoint];
                rightPoint--;
            }
        }
        // 将最开始存储的分界值放入当前的"坑"中
        arr[rightPoint] = pivot;
        return rightPoint;
    }

    /**
     * 单边指针
     * 思路：
     * 记录首元素为分界值 pivot, 创建标记 mark 指针。
     * 循环遍历与分界值对比。
     * 比分界值小，则 mark++ 后与之互换。
     * 结束循环后，将首元素分界值与当前mark互换。
     * 返回 mark 下标为分界值下标。
     */
    private static  int singlePointer(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int markPoint = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            // 如果比分界值小，则 mark++ 后互换。
            if (arr[i] < pivot) {
                markPoint++;
                int temp = arr[markPoint];
                arr[markPoint] = arr[i];
                arr[i] = temp;
            }
        }
        // 将首元素分界值与当前mark互换
        arr[startIndex] = arr[markPoint];
        arr[markPoint] = pivot;
        return markPoint;
    }

}
