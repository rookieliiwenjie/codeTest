package LeetCode.DP;

public class Change {

    public static void main(String[] args) {
        Change change = new Change();
        int[] coins = {1,  5,2};
        System.out.println(change.change(5, coins));
    }

    public int change(int amount, int[] coins) {
        int num = 0;
        if (coins.length == 0) {
            return num;
        }
        //初始状态
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                //状态转移方程 dp[i] = dp[i] + dp[i - coin] 从0到i的金额，有多少种组合方式
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
