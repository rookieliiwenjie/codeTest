package LeetCode.oneHuFive;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = num ^ result;
        }
        return result;
    }
}
