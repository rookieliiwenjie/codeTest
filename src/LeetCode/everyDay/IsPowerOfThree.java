package LeetCode.everyDay;

public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        double cbrt = Math.cbrt(n);
        return Math.floor(cbrt) == cbrt;
    }

    //求一个数是否是 3的幂方
    public boolean isPowerOfThree2(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    //数学的方式， 就是看 是否能被 3^19整除
    public boolean isPowerOfThree3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        IsPowerOfThree isPowerOfThree = new IsPowerOfThree();
        isPowerOfThree.isPowerOfThree(9);
    }
}
