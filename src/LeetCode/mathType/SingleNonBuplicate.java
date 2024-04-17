package LeetCode.mathType;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/17 2:42 下午
 * @Description:
 */
public class SingleNonBuplicate {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,1,2,3,4,5};
        System.out.println("single(arr) = " + single(arr));
    }
    public static int single(int nums[]){
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
