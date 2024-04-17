package LeetCode.oneHuFive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Rotate {
    public static void main(String[] args) {
        Rotate rotate = new Rotate();
//        int nums[] = {1, 2, 3, 4, 5, 6, 7};
//        int k = 3;
//        int nums[] = {-1,-100,3,99};
//        int k = 2;
//        int nums[] = {-1};
//        int k = 2;
        int nums[] = {1,2};
        int k = 3;
        rotate.rotate4(nums, k);
    }

    public void rotate(int[] nums, int k) {
        int left = k - 1;
        int right = nums.length - 1;
        while (left >= 0) {
            int leftNum = nums[left];
            int rightNum = nums[right];
            nums[left] = rightNum;
            nums[right] = leftNum;
            left--;
            right--;
        }
    }

    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        int leftIndex = 0;
        int rightIndex = length - k;
        int right = k - 1;
        boolean flag = false;
        for (int i = k; i < length; i++) {
            while (rightIndex <= i && rightIndex < length) {
                int left = nums[rightIndex];
                int rgiht = nums[right];
                nums[rightIndex] = rgiht;
                nums[left] = left;
                rightIndex++;
                right--;
                flag = true;
            }
            if (flag) break;
            int leftNum = nums[leftIndex];
            nums[i] = leftNum;
            leftIndex++;
        }
    }

    /**
     * 从3开始是正确的
     * @param nums
     * @param k
     * 使用了一个数组
     * 愚蠢的方式
     */
    public void rotate3(int[] nums, int k) {

        List<Integer> integerList = new ArrayList<>();
         k =k%nums.length;
        int kInd = k;
        while (kInd > 0&&nums.length-kInd>=0 ) {
            integerList.add(nums[nums.length-kInd]);
            kInd--;
        }
        int leftIndex = nums.length-k-1;
        for (int i = nums.length-1; i >=k && leftIndex>=0 ;i--) {
           int leftNum = nums[leftIndex];
           nums[i] = leftNum;
           leftIndex--;
        }

        for (int i = 0; i < integerList.size(); i++) {
            nums[i] = integerList.get(i);
        }

    }

    /**
     * 一个数组的方法
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        int length = nums.length;
        int newNums[]= new int[length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(i+k)%length] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, length);
    }

    /**
     * 不使用数组 ，目前规划是环形
     * @param nums
     * @param k
     */
    public void rotate5(int[] nums, int k) {

    }
}
