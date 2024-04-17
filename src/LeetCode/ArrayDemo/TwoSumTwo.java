package LeetCode.ArrayDemo;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/8 10:10 上午
 * @Description:
 */
public class TwoSumTwo {

    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        int target = 9;

//        int arr[] = {2, 3, 4};
//        int target = 6;
//
//        int arr[] = {-1, 0};
//        int target = -1;
        //  System.out.println("target = " + Arrays.stream(Arrays.stream(Objects.requireNonNull(twoSum(arr, target))).toArray()).iterator());
        System.out.println("target = " + Arrays.stream(Arrays.stream(Objects.requireNonNull(twoSum3(arr, target))).toArray()).iterator());
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (target == (numbers[i] + numbers[j])) {
                    return new int[]{i + 1, j + 1};
                }
            }

        }
        return null;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int num = target - numbers[i];
                if (num < numbers[mid]) {
                    right = mid - 1;
                } else if (num > numbers[mid]) {
                    left = mid + 1;
                } else {
                    return new int[]{i + 1, mid + 1};
                }
            }

        }
        return null;
    }


    public static int[] twoSum3(int[] numbers, int target) {
        if (numbers == null) return null;
        int low = 0, hight = numbers.length - 1;
        while (low < hight) {
            if (target > (numbers[low] + numbers[hight])) {
                low++;
            } else if (target < (numbers[low] + numbers[hight])) {
                hight--;
            } else {
                return new int[]{low + 1, hight + 1};
            }
        }
        return null;
    }

    public static int[] twoSum7(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}

