package LeetCode.ArrayDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/29 8:43 下午
 * @Description:
 */
public class AverageValue {
    public static  int averageValue(int nums[]){
        int sum = 0;
        int index = 0;
        for (int num: nums) {
            if(num%6==0){
                index++;
                sum+=num;
            }
        }
        return index == 0?0:sum/index;
    }
}
