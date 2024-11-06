package LeetCode.everyDay;

import java.util.Arrays;

public class ResultsArray {
    // n+k
    public int[] resultsArray(int[] nums, int k) {
        int index = nums.length - k + 1;
        int[] resluts = new int[index];
        for (int i = 0; i < index; i++) {
            int left = nums[i];
            boolean flag = true;
            for (int j = i; j < i + k; j++) {
                if (nums[j] != left) {
                    flag = false;
                    break;
                }
                left++;
            }
            if (flag) {
                resluts[i] = left - 1;
            } else {
                resluts[i] = -1;
            }
        }
        return resluts;
    }

    // on算法
    public int[] resultsArray2(int[] nums, int k) {
        int index = nums.length - k + 1;
        int[] resluts = new int[index];
        Arrays.fill(resluts, -1);
        int cut = 0;
        for (int i = 0; i < index; i++) {
            cut = i == 0 || nums[i] == nums[i - 1] + 1 ? cut + 1 : 1;
            if (cut >= k) {
                resluts[i - k + 1] = nums[i];
            }
        }
        return resluts;
    }

    // [1] 1 这种就会报错
    public int[] resultsArray3(int[] nums, int k) {
        int index = nums.length - k + 1;
        int[] resluts = new int[index];
        Arrays.fill(resluts, -1);
        int cut = 1;
        for (int i = 1; i < index; i++) {
            cut = nums[i] == nums[i - 1] + 1 ? cut + 1 : 1;
            if (cut >= k) {
                resluts[i - k + 1] = nums[i];
            }
        }
        return resluts;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 3, 2, 5 };
        int k = 3;
        // int nums[] = { 2,2,2,2,2 };
        // int k = 4;
        // int nums[] = { 3, 2, 3, 2, 3, 2 };
        // int k = 2;
        ResultsArray resultsArray = new ResultsArray();
        int resluts[] = resultsArray.resultsArray3(nums, k);
        for (int resluts2 = 0; resluts2 < resluts.length; resluts2++) {
            System.err.println(resluts[resluts2]);
        }

    }
}