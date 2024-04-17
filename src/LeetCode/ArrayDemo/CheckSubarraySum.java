package LeetCode.ArrayDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/3 10:28 上午
 * @Description:
 */
public class CheckSubarraySum {
    /**
     * 这里有两个问题，
     * 1、因为 和可以为k的倍数，所以滑动窗口变动的条件不太好确定。 可以使用前缀和处理
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int nums[],int k){
        int lenght = nums.length;
        if(lenght<2){
            return false;
        }
        int newNums [] = new int[lenght+1];
        for (int i = 0; i < nums.length; i++) {
            newNums[i+1]=newNums[i] +nums[i];
        }
        return true;
    }
}
