package LeetCode.DP;

public class QingwaDp {

    public static void main(String[] args) {

        QingwaDp dp = new QingwaDp();
        System.out.println(dp.dp(6));
    }

    public int dp(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int cur = 1;
        int next = 2;
        for (int i = 3; i < n; i++) {
            int temp = cur + next;
            cur = next;
            next = temp;
        }
        return next + cur;
    }
}
