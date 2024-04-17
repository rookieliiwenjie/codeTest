package LeetCode;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/5 12:35 上午
 * @Description:
 */
public class Factorial {

    public static void main(String[] args) {
        factorial(6);
    }
    //x = (n-1) *n;

    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n * factorial(n - 1);
    }
}
