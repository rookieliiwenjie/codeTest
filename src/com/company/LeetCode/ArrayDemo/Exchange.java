package com.company.LeetCode.ArrayDemo;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author rookie.li
 * @date 2021-10-08 22:02
 */
public class Exchange {

    public int[] exchange(int[] nums) {
        int newNums[] = new int[nums.length];
        int right = nums.length - 1;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                newNums[right] = nums[i];
                right--;
            } else {
                newNums[left] = nums[i];
                left++;
            }
        }
        return newNums;
    }

    public int[] exchangeDobule(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int tmp = 0;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while ((left < right) && nums[right] % 2 == 0) {
                right--;
            }
            tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return nums;
    }
}
