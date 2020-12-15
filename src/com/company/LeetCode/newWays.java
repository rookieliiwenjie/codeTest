package com.company.LeetCode;

/**
 * @Author rookie.li
 * @create 2020/11/2
 */
public class newWays {
    /*一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
。*/
    public static void main(String[] args) {

    }


    /**
     * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/javaqing-wa-tiao-tai-jie-he-fei-bo-na-qi-shu-lie-t/
     * @param n
     * @return
     */
    public static int numWays2(int n){
        if (n <= 1)
            return 1;
        if (n < 3)
            return n;
        return numWays2(n - 1) + numWays2(n - 2);
    }
    public int numWays(int n) {
        if (n <= 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
    public static int numWays5(int n){
        if(n<=1){
            return 1;
        }
        int dp[]  = new int[n+1];
        dp[1] = 1;
        dp[2] =2;
        for (int i = 3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
            dp[i]%=1000000007;
        }
        return dp[n];

    }
    public static int numWays3(int n) {
        //这也是一个斐波那契数列
        //不管最后n接的跳台,最后一定是跳上1或跳上2
        //如果是1级那么剩下n-1个台阶f(n-1)
        //如果是2级那么剩下n-2个台阶f(n-2)
        //另外初值不一样 f(0)=1 , f(1)=1
        if(n==0 || n==1)
            return 1;

        int num1=1,num2=1,sum=0;
        while(n>=2){
            sum=(num1+num2)%1000000007;
            num1=num2;
            num2=sum;
            n--;
        }
        return sum;

    }

}
