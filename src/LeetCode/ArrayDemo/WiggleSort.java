package LeetCode.ArrayDemo;

import java.util.Arrays;

public class WiggleSort {
    public static void main(String[] args) {
        WiggleSort wiggleSort = new WiggleSort();
//        int[] nums = {1, 5, 1, 1, 6, 4};
        int nums[] = {5, 3, 1, 2, 3};
        wiggleSort.wiggleSort2(nums);
    }

    public void wiggleSort(int[] nums) {
        int[] newNums = new int[nums.length];
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        boolean flag = true;
        while (left <= right) {
            if (flag) {
                newNums[i] = nums[right];
                right--;
                flag = false;
            } else {
                newNums[i] = nums[left];
                left++;
                flag = true;
            }
            i++;
        }
        for (int j = 0; j < newNums.length; j++) {
            nums[j] = newNums[j];
        }
    }


    public void wiggleSort2(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int num = nums[right];
        boolean flag = true;
        int i = 0;
        while (left <= right) {
            if (flag) {
                int newNum = nums[left];
                nums[i] = nums[right];
                num = newNum;
                right--;
                left++;
                flag = false;
            } else {
                int newNum = nums[left];
                nums[i] = num;
                num = newNum;
                right--;
                flag = true;
            }
            i++;
        }
        System.out.println(Arrays.toString(nums));
    }


    public void wiggleSort3(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1) {

            } else {

            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
