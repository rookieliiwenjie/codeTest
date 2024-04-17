package LeetCode.ArrayDemo;

import java.util.Map;
import java.util.Properties;

public class LongestAlternationgSubarray {
    public static void main(String[] args) {
//        int nums[] = {2, 8};
//        int threshold = 4;
        int nums[] = {1, 2};
        int threshold = 2;
        LongestAlternationgSubarray longestAlternationgSubarray = new LongestAlternationgSubarray();
        System.out.println(longestAlternationgSubarray.longestAlternatingSubarray(nums, threshold));
        Properties properties = System.getProperties();
        properties.forEach((k, v) -> {
            System.out.println("properties"+k + ":" + v);
        });
        Map<String, String> getenv = System.getenv();
        getenv.forEach((k, v) -> {
            System.out.println("getenv"+k + ":" + v);
        });

    }

    /**
     * l r
     *
     * @param nums
     * @param threshold
     * @return
     * {@link #main(String[])} 
     */
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLen = 0;
        int dp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > threshold) {
                dp = 0;
            } else if (i == nums.length - 1 || nums[i] % 2 != nums[i + 1] % 2) {
                dp++;
            } else {
                dp = 1;
            }
            if (nums[i] % 2 == 0) {
                maxLen = Math.max(maxLen, dp);
            }
        }
        return maxLen;
    }

}
