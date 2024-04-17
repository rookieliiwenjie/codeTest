package LeetCode.oneHuFive;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int nums[] = {3, 2, 3};
        System.out.println(majorityElement.majorityElement(nums));
    }
    /**
     * 排序后处理
     * @param nums
     * @return
     */
    public int majorityElement(int [] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * o(n)
     * o(1)
     * @param nums
     * @return
     */
    public int majorityElement2(int [] nums){
        return 0;
    }
}
