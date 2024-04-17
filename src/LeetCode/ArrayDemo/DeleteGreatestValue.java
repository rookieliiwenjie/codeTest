package LeetCode.ArrayDemo;

import java.util.Arrays;

public class DeleteGreatestValue {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 4}, {3, 3, 1}};
//        //int arr[][] = {{10}};
//        System.out.println(deleteGreatestValue(arr));
        deleteGreatestValue(arr);
        System.out.println("----");
    }


    public static void deleteGreatestValue(int[][] grid) {
        return ;
//        int m = grid.length - 1;
//        int n = grid[0].length - 1;
//        int max = 0;
//        for (int [] arr:grid) {
//            Arrays.sort(arr);
//        }
//        for (int i = 0; i <= n; i++) {
//            int forMax = 0;
//            for (int j = 0; j <= m; j++) {
//                forMax = Math.max(forMax, grid[j][i]);
//            }
//            max += forMax;
//        }
//        return max;
    }

    public int deleteGreatestValue2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            int mx = 0;
            for (int i = 0; i < m; i++) {
                mx = Math.max(mx, grid[i][j]);
            }
            res += mx;
        }
        return res;
    }
}
