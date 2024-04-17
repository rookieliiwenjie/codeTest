package LeetCode.ArrayDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/25 1:58 下午
 * @Description:
 */
public class MinNumber {
    public static void main(String[] args) {
//        int arr[] = {10, 2};
//        int ar2r[] = {3, 30, 34, 5, 9, 1};
        int ar3[] = {65, 58, 95, 10, 57, 62, 13, 106, 78, 23, 85};
        System.out.println("ar2r = " + qsort(ar3, 0, ar3.length - 1));
    }

    public static String minNumber1(int[] nums) {
        List<Integer> charNumber = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            String s = String.valueOf(nums[i]);
            for (int j = 0; j < s.length(); j++) {
                charNumber.add(s.charAt(j) - '0');
            }

        }
        Collections.sort(charNumber);
        int zoreNum = 0;
        boolean flag = true;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charNumber.size(); i++) {
            if (charNumber.get(i) == 0 && flag) {
                zoreNum++;
            }
            if (charNumber.get(i) != 0) {
                stringBuilder.append(charNumber.get(i));
                flag = false;
                if (zoreNum > 0) {
                    while (zoreNum > 0) {
                        stringBuilder.append(0);
                        zoreNum--;

                    }
                }
            }

        }
        return stringBuilder.toString();
    }

    public static String minNumber2(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = Integer.toString(nums[i]);
        }
        quickSortMin(strings, 0, nums.length);
        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            newString.append(strings[i]);
        }
        return newString.toString();
    }

    void quickSort(String[] strs, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while (i < j) {
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) {
                j--;
            }
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) {
                i++;
            }
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }

    public static void quickSortMin(String[] nums, int start, int end) {
        int i = start;
        int j = end;
        String mid = nums[i];
        while (i > j) {
            while ((nums[j] + nums[i]).compareTo(nums[i] + nums[j]) >= 0 && i>j) {
                j--;
            }
            while ((nums[i] + nums[j]).compareTo(nums[j]+nums[i]) <= 0) {
                i++;
            }
        }
        nums[i] = nums[j];
        nums[j]  = mid;
        quickSortMin(nums,start,i-1);
        quickSortMin(nums,j+1,end);

    }

    public static String minNumber(int[] nums) {
        List<Integer> charNumber = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            String s = String.valueOf(nums[i]);
            for (int j = 0; j < s.length(); j++) {
                charNumber.add(s.charAt(j) - '0');
            }

        }
        Collections.sort(charNumber);
        int zoreNum = 0;
        boolean flag = true;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charNumber.size(); i++) {
            if (charNumber.get(i) == 0 && flag) {
                zoreNum++;
            }
            if (charNumber.get(i) != 0) {
                stringBuilder.append(charNumber.get(i));
                flag = false;
                if (zoreNum > 0) {
                    while (zoreNum > 0) {
                        stringBuilder.append(0);
                        zoreNum--;

                    }
                }
            }

        }
        return stringBuilder.toString();
    }


    public static int[] qsort(int arr[], int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (arr[j] > pivot) {
                j--;
            }
            while (arr[i] < pivot) {
                i++;
            }
            if ((arr[i] == arr[j])) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start) {
            arr = qsort(arr, start, i - 1);
        }
        if (j + 1 < end) {
            arr = qsort(arr, j + 1, end);
        }
        return arr;
    }
}
