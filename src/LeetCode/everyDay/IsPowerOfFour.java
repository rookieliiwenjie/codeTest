package LeetCode.everyDay;

public class IsPowerOfFour {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && ((n & 0x55555555) != 0);
    }

    public static void main(String[] args) {
        IsPowerOfFour isPowerOfFour = new IsPowerOfFour();
        boolean flag = isPowerOfFour.isPowerOfFour2(16);
        System.out.println(flag);
    }

    public boolean isPowerOfFour2(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    /**
     * 是否是取模的特性
     * 4^ x = (3+1)^x = 3^x * 1^x = 1;
     * 如果 n 是 2 的幂却不是 4 的幂，那么它可以表示成 4 ×2 的形式，此时它除以 3 的余数一定为 2
     * @param n
     * @return
     */
    public boolean isPowerOfFour3(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}
