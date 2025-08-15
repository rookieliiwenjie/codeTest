package LeetCode.DP;

public class ClimbStairs {
    /*
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 示例 1：
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 示例 2：
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int res = climbStairs.climbStairs(45);
        System.out.println(res);
        int res2 = climbStairs.climbStairs2(45);
        System.out.println(res2);
    }

    public int climbStairs2(int n) {
        if (n <= 1) {
            return 1;
        }
        int de[] = new int[n + 1];
        de[1] = 1;
        de[2] = 2;
        for (int i = 3; i <= n; i++) {
            de[i] = de[i - 1] + de[i - 2];
        }
        return de[n];

    }
    public int climbStairs3(int n) {
        if (n <= 1) {
            return 1;
        }
        int de[] = new int[n + 1];
        de[1] = 1;
        de[2] = 2;
        for (int i = 3; i <= n; i++) {
            de[i] = de[i - 1] + de[i - 2];
        }
        return de[n];

    }
}
