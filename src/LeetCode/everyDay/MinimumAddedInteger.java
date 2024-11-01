package LeetCode.everyDay;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumAddedInteger {
    /**
     * num1删除两个数，然后每个数据
     * num1+x =num2
     *
     * @param num1
     * @param num2
     * @return
     */
    public static void main(String[] args) {
        MinimumAddedInteger minimumAddedInteger = new MinimumAddedInteger();
        int num1[] = {4,20,16,12,8};
        int num2[] = {14,18,10};
        int i = minimumAddedInteger.minimumAddedInteger(num1, num2);
        System.out.println(i);
    }

    public int minimumAddedInteger(int num1[], int num2[]) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        HashMap<Integer, Integer> numKey = new HashMap<>();
        int length = num2.length;
        for (int i = 0; i < num1.length; i++) {
            int x;
            if (i<length){
                 x = num2[i] - num1[i];
            }else {
                 x = num2[length-1] - num1[i];

            }
            numKey.put(x, numKey.getOrDefault(x, 0) + 1);
        }
        int result = 0;
        for (Integer key : numKey.keySet()) {
            if (numKey.get(key) == length - 2) {
                result = numKey.get(key);
            }
        }
        return result;
    }
}
