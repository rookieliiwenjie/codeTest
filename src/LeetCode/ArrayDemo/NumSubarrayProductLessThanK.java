package LeetCode.ArrayDemo;

public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {
        int nums[] = {10, 5, 2, 6};
        int k = 100;
        //int nums[] = {1, 2, 3};
        // int k = 0;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int sum = 0;
        if (k < 2) {
            return 0;
        }
        int lenght = nums.length;
        for (int i = 0; i < lenght; i++) {
            int curNum = nums[i];
            for (int j = i+1; j < lenght; j++) {
                if (curNum < k) {
                    curNum *= nums[j];
                    sum++;
                } else {
                    break;
                }
            }
        }
        return sum;
    }
}
