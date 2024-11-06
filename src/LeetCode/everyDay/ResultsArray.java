package LeetCode.everyDay;

import java.util.Arrays;

public class ResultsArray {
    //n+k
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

        }
        return resluts;
    }

    public static void main(String[] args) {
        // int nums[] = { 1, 2, 3, 4, 3, 2, 5 };
        // int k = 3;
        // int nums[] = { 2,2,2,2,2 };
        // int k = 4;
        int nums[] = { 3, 2, 3, 2, 3, 2 };
        int k = 2;
        ResultsArray resultsArray = new ResultsArray();
        int resluts[] = resultsArray.resultsArray2(nums, k);
        for (int resluts2 = 0; resluts2 < resluts.length; resluts2++) {
            System.err.println(resluts[resluts2]);
        }

    }
}