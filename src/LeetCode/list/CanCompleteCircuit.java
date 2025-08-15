package LeetCode.list;

public class CanCompleteCircuit {
    /**
     * @param gas  汽油站的油量
     * @param cost 耗费的油量
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + gas[i];
            dp[i][1] = dp[i - 1][1] + cost[i];
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int sum[] = new int[n];
        for (int i = 0; i < n; i++) {
            sum[i] = gas[i] - cost[i];
        }
        for (int i = 0; i < n; i++) {
            if (sum[i] < 0) {

            }
        }
        return -1;
    }
}
