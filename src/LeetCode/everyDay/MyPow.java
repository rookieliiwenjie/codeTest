package LeetCode.everyDay;

public class MyPow {

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double v = myPow.myPow(2.1, 3);
        System.out.println("v==" + v);
    }

    public double myPow(double x, int n) {
        int flag = x > 0 ? 1 : (n / 2 == 0 ? 1 : -1);
        int res = 1;
        if (x == 0 || n == 0) {
            return res;
        }
        double mod = 1;
        while (n > 1) {
            if (n % 2 == 1) {
                mod = mod * x;
            }
            x = x * x;
            n = n / 2;
        }
        return x * flag * mod;
    }
}
