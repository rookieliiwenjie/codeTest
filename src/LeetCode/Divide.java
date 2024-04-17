package LeetCode;

/**
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数dividend除以除数divisor得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author rookie.li
 * @date 2021-09-21 21:16
 */
public class Divide {

    public static void main(String[] args) {
        int divide = div2(2147483601, 2);
        System.out.println("divide = " + divide);
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
            return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
        }
        long num = 0;
        boolean lose = false;
        long dividendlong = (long) dividend;
        long divisorLong = (long)(divisor);
        if (dividendlong < 0 && divisorLong < 0) {
            dividendlong = dividendlong < 0 ? -dividendlong : dividendlong;
            divisorLong = divisorLong < 0 ? -divisorLong : divisorLong;
        } else if (dividend < 0 || divisor < 0) {
            lose = true;
            dividendlong = dividendlong < 0 ? -dividendlong : dividendlong;
            divisorLong = divisorLong < 0 ? -divisorLong : divisorLong;
        }
        while (dividendlong >= divisorLong) {
            dividendlong = dividendlong - divisorLong;
            num++;
        }
        if (lose) {
            return (int)-num;

        } else {
            return (int) num;

        }
    }

    public static int div2(int dividend, int divisor) {

        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
             if (dividend > Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
            return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
        }
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = -1;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        long res = div(a, b);
        if (sign > 0) return res > Integer.MAX_VALUE ? Integer.MAX_VALUE  : (int) res;
        return (int) -res;




    }
    public static int div(long a, long b) {  // 似乎精髓和难点就在于下面这几句
        if (a < b) return 0;
        long count = 1;
        long tb = b; // 在后面的代码中不更新b
        while ((tb + tb) <= a) {
            count = count + count; // 最小解翻倍
            tb = tb + tb; // 当前测试的值也翻倍
        }
        return (int) (count + div(a - tb, b));
    }
    public int divide3(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        /**
         *  // 1表示正数，-1表示负数
         */
        int sign = 1;
        int res = 0;
        if((dividend>0 && divisor<0) || (dividend<0 && divisor>0)){
            sign = -1;
        }

        if(dividend>0) dividend = -dividend;
        if(divisor>0) divisor = -divisor;

        while(dividend <= divisor){
            int value = divisor;
            int k = 1;
            // 例如：被除数是22，除数是3，第一个：value=3+3，k=1+1,；第二次：value=6+6，k=2+2，第三次终止循环
            // 考虑到 value + value 可能会越界，所以加上了 value >= 0xc0000000
            // 0xc0000000 是十进制 -2^30 的十六进制表示，它是最小值 -2^31 的一半，而 divisor 的值不可能比 -2^31 还要小，所以 value 不可能比 0xc0000000 小
            while(value >= 0xc0000000 && dividend <= value + value){
                value += value;
                k += k;
            }

            dividend -= value;
            res += k;
        }

        return sign * res;
    }
}
