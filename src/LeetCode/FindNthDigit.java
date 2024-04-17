package LeetCode;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/5 6:16 下午
 * @Description:
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n - 1;
        }
        //多少个10
        int num = 2;
        n = n - 10;

        while (n > 0 && (n - num * 10) > 0) {
            n -= num * 10;
            num++;
        }
        int x = 0;
        while (num > 0) {
            x += num * 10 + n;
        }
        return n;
    }

    public int findNthDigit2(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }
}
