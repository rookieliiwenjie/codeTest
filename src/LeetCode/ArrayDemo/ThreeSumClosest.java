package LeetCode.ArrayDemo;

import java.util.Arrays;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/10 11:05 上午
 * @Description:
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int num = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (left < right) {
            int newNum = nums[left] + nums[right];
            for (int i = left + 1; i < right - 1; i++) {
                newNum += nums[i];
                if (newNum == target) {
                    return newNum;
                }
                int sumNum = newNum < 0 ? (target + newNum) : (target - newNum);
                if(Math.abs((sumNum))<newNum){
                    newNum = sumNum;
                    index = i;
                }
            }
            if(newNum<0){

            }

        }
        return num;
    }

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
                return;
            }
            System.out.println(" = ");
        }
    }
}
