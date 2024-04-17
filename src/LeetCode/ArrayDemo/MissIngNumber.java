package LeetCode.ArrayDemo;

public class MissIngNumber {
    public static void main(String[] args) {
        MissIngNumber missIngNumber = new MissIngNumber();
//        int[] nums = {3, 0, 1};
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missIngNumber.missingNumber(nums));
    }

    /**
     * 1、hash表
     * 2、位运算
     * 3、数学解决
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int num = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            num += i;
            sum += nums[i];
        }
        return num - sum;
    }

}
