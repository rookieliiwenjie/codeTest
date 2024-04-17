package LeetCode.mathType;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/12 10:42 上午
 * @Description:
 */
public class AlternateDigitSum {
    public static void main(String[] args) {
        char a = '1' - 48;
        char b = '2' - 48;
        System.out.println("a+b= " + (a + b));
        System.out.println("b = " + alternateDigitSum2(8869));

        //System.out.println("b = " + alternateDigitSum2(521));
    }

    public static int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                num += c - '0';
            } else {
                num -= c - '0';
            }
        }
        return num;
    }

    public static int alternateDigitSu3(int n) {
        String s = String.valueOf(n);
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            num += i % 2 == 0 ? c : -c;
        }
        return num;
    }

    public static int alternateDigitSum2(int n) {
        //(a+b)xc = axc+bXc  这里描述有问题吧 a 可以理解为 +b 本身就是 +(-1)
        // a-b+c-d+f
        int res = 0, sign = 1;
        while (n > 0) {
            res += n % 10 * sign;
            sign = -sign;
            n /= 10;
        }
        //这里其实就是一个奇数和偶数的处理当位数位偶数是最后sing = 1 单其实应该就是将所有位数都搞反了应该去反
        return -sign * res;
    }

    public static int alternateDigitSum4(int n) {
        //(a+b)xc = axc+bXc  这里描述有问题吧 a 可以理解为 +b 本身就是 +(-1)
        // a-b+c-d+f  为啥初始不能位-1 因为要兼容只有一位的

        int res = 0, sign = -1;
        int index = 0;
        while (n > 0) {
            res += n % 10 * sign;
            sign = -sign;
            n /= 10;
            index++;
        }
        //这里其实就是一个奇数和偶数的处理当位数位偶数是最后sing = 1 单其实应该就是将所有位数都搞反了应该去反
        return index==1 ? -res : res;
    }
}
