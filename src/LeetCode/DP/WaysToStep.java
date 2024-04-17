package LeetCode.DP;

public class WaysToStep {
    public static void main(String[] args) {
        WaysToStep waysToStep = new WaysToStep();
        System.out.println(waysToStep.waysToStep(61));
    }

    public int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i - 3] + dp[i - 2])% 1000000007 + dp[i - 1]) % 1000000007;
            dp[i]%=1000000007;
        }
        return dp[n];
    }
}
