package LeetCode.mathType;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/17 4:28 下午
 * @Description:
 */
public class FindMaximumXOR {
    public static void main(String[] args) {
        int arr[] = {3,10,5,25,2,8};
        findMaximumXOR(arr);
    }

    /**
     * 如何优化时间复杂度，这个点切入不了
     * @param nums
     * @return
     */
    public static int findMaximumXOR(int [] nums){
        int max = 0;

        for (int i = 0; i <nums.length ; i++) {
            for (int j = i; j < nums.length; j++) {
              max= Math.max(nums[i]^nums[j],max);
            }
        }
        return max;
    }

}
