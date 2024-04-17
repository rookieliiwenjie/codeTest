package LeetCode.mathType;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/16 9:03 下午
 * @Description:
 */
public class UglyNumber {
    public static void main(String[] args) {
        int i = nthUglyNumber(12);
        System.out.println("i = " + i);
    }

    public static int nthUglyNumber(int n) {
        int sum = 0;
        int nums[] = {2, 3, 5};
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            int x = i;
            for (int num : nums) {
                while (x % num == 0) {
                    x = x / num;
                }
                continue;
            }
            if (x == 1) {
                sum++;
            }
            if (n == sum) {
                return i;
            }
        }
        return 1;
    }
}
