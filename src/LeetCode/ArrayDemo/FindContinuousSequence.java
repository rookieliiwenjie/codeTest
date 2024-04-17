package LeetCode.ArrayDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/11 5:52 下午
 * @Description:
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        int[][] continuousSequence = findContinuousSequence(1);
        System.out.println("continuousSequence = " + continuousSequence);
    }

    public static int[][] findContinuousSequence(int target) {
        int left = 1;
        int quickIndex = 1;
        List<int[]> arr = new ArrayList<>();
        int sum = 0;
        while (left < target && quickIndex < target) {
            sum += quickIndex;
            if (sum == target) {
                int newList[] = new int[quickIndex - left + 1];
                int i = 0;
                while (left <= quickIndex) {
                    newList[i] = left;
                    left++;
                    i++;
                }
                arr.add(newList);
                left++;
                quickIndex = left;
                sum = 0;
                continue;
            } else if (sum > target) {
                left++;
                quickIndex = left;
                sum = 0;
                continue;
            }
            quickIndex++;
        }
        int[][] a = new int[arr.size()][];
        for (int i = 0; i < arr.size(); i++) {
            a[i] = arr.get(i);
        }
        return a;
    }
}
