package com.company.LeetCode.ArrayDemo;

public class MajarityElement {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(majarityElement(nums));
    }

    public static int majarityElement(int[] nums) {
        int num = -1;
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                num = n;
            }
            if (num != n) {
                count--;
            } else {
                count++;
            }
        }
        count = 0;
        for (int n : nums) {
            if (num == n) {
                count++;
            }
        }
        return count > nums.length / 2 ? num : -1;
    }
}
