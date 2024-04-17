package LeetCode.Tree;

import java.util.Arrays;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/31 10:06 上午
 * @Description:
 */
public class MctFromLeafValues {
    /**
     * 中序遍历的数组（左根右），节点要不两个要不没有（这里是构建二叉树的另一个条件）
     * 求最小的叶节点值
     * @param arr
     * @return
     */
//    public int macFromLeafValues(int[] arr) {
//
//        return 0;
//    }
//
//    public void buildTree(){
//
//    }
    public static void main(String[] args) {
        int arr [] ={6,2,4};
        mctFromLeafValues(arr);
    }
    public static int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 4);
        }
        int[][] mval = new int[n][n];
        for (int j = 0; j < n; j++) {
            mval[j][j] = arr[j];
            dp[j][j] = 0;
            for (int i = j - 1; i >= 0; i--) {
                mval[i][j] = Math.max(arr[i], mval[i + 1][j]);
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + mval[i][k] * mval[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
