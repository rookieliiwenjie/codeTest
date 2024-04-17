package LeetCode.ArrayDemo;

import java.util.Arrays;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/6 8:06 下午
 * @Description: 这个主要是一个公式
 * 也是使用了前缀和的方法： 右侧
 * sum= 左侧 total 总数
 * total- sum - numi(中位数不参与)
 * sum = total -sum - numi
 * total = 2sum+numi
 */
public class PivotIndex {
    public static void main(String[] args) {
        //int arr [] = {1,7,3,6,5,6};
        //int arr[] = {1, 2, 3};
//        int arr[] = {2, 1, -1};
        int arr[] = {-1, -1, -1, -1, -1, -1, 0};
        System.out.println("arr = " + pivotIndex(arr));
    }

    public static int pivotIndex(int nums[]) {
        int left = 0;
        int right = nums.length - 1;
        int sumLeft = 0;
        int sumRight = nums[right];
        right--;
        while (left < right) {

            if (sumLeft > sumRight + nums[right]) {
                sumRight += nums[right];
                right--;
            } else if (sumLeft < sumRight + nums[right]) {
                sumLeft += nums[left];
                left++;
            } else {
                if (left == 0 && right == 1) {
                    return 0;
                }
                return left;
            }
        }
        return -1;
    }

    public static int pivotIndex2(int nums[]) {
        int tatal = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == tatal) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
