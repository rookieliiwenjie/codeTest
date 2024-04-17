package LeetCode.ArrayDemo;

import java.util.Arrays;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-10-08 17:12
 */
public class MajorityElement {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * <p>
     * <p>
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法
     *
     * @param nums
     * @return
     */
    public int majorityElementMore(int[] nums) {

        int title = 0;
        int numMore = 0;
        for (int num : nums) {
            //没有中数为众数赋值
            if (title == 0) {
                numMore = num;
            }
            title += (num == numMore ? 1 : -1);
        }
        return numMore;
    }
}
