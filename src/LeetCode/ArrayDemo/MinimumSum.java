package LeetCode.ArrayDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinimumSum {
    public static void main(String[] args) {
        MinimumSum ms = new MinimumSum();
//        int[] nums = {8, 6, 1, 5, 3};
//        int[] nums = {5, 4, 8, 7, 10, 2};

        int[] nums = {1,2,1};
//        int[] nums = {2, 2, 1};
        System.out.println(ms.minimumSum(nums));
    }

    public int minimumSum(int nums[]) {
        int num = -1;
        if (nums.length < 3) {
            return num;
        }
        int[][] numArray = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numArray[i][0] = nums[i];
            numArray[i][1] = i;
        }
        num = Integer.MAX_VALUE;
        Arrays.sort(numArray, Comparator.comparingInt(o -> o[0]));
        int right = nums.length - 1;
        while (right >= 0) {
            int rightIndex = numArray[right][1];
            int rightNum = numArray[right][0];
            if (rightIndex == 0) {
                right--;
                continue;
            }
            int[] indexFlag = {60, 60};
            for (int i = right - 1; i >= 0; i--) {
                if (rightNum > numArray[i][0] && numArray[i][1] < rightIndex && indexFlag[0] > numArray[i][0]) {
                    indexFlag[0] = numArray[i][0];
                }
                if (rightNum > numArray[i][0] && numArray[i][1] > rightIndex && indexFlag[1] > numArray[i][0]) {
                    indexFlag[1] = numArray[i][0];
                }
            }
            if (indexFlag[0] != 60 && indexFlag[1] != 60) {
                num = Math.min(num, indexFlag[0] + indexFlag[1] + numArray[right][0]);
            }
            right--;
        }

        return num == Integer.MAX_VALUE ? -1 : num;
    }
}
