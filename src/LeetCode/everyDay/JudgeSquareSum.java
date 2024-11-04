package LeetCode.everyDay;

public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        boolean flag = false;
        int i = 0;
        int sum = 1;
        if (c == 0) {
            return true;
        }
        while (sum <= c) {
            int j = i;
            while (sum <= c) {
                sum = i * i + j * j;
                if (sum == c) {
                    flag = true;
                    break;
                }
                j++;
            }
            if (flag) {
                System.out.println(i + "-" + j);
                break;
            }
            i++;
            sum = i * i;
        }
        return flag;
    }

    // 2ab = (a+b)(a+b) -c
    public boolean judgeSquareSum2(int c) {
        boolean flag = false;
        int i = 0;
        if (c == 0) {
            return true;
        }
        while (i <= c) {
            if (((i * i) - c) >= 0 && ((i * i) - c) % 2 == 0) {
                flag = true;
                break;
            }
            i++;
        }
        return flag;
    }

    public boolean judgeSquareSum3(int c) {
        for (int i = 0; i * i <= c; i++) {
            double b = Math.sqrt(c - (i * i));
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        double a = 1.1;
        int b = (int) a;
        System.out.println(a);
        System.out.println(b);
        JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
        // int c = 8;
        // int c = 0;
        int c = 3;
        // int c= 4;
        // int c = 2;
        // int c = 3;
        // int c = 2147482647;
        boolean flag = judgeSquareSum.judgeSquareSum3(c);
        System.out.println(flag);
    }

}
