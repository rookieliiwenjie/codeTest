package LeetCode;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/5 11:15 上午
 * @Description:
 */
public class GetNum {
    public static void main(String[] args) {
        System.out.println("getNums(2,10) = " + getNums(2,11));
    }

    public static double getNums(double x, long n) {
        if (n == 0) {
            return 1;
        }
        System.out.println("n = " + n);
        double y = n >= 0 ? getNums(x, n / 2) : getNums(1 / x, n / 2);
        System.out.println("y = " + y);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
