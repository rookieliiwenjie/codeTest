package LeetCode;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/5 6:51 下午
 * @Description:
 */
public class MaxValue {
    public static int maxValue(int [][] grid){
        //向右或向下移动
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        int f [][] = new int[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i>0){

                }
                if(j>0){

                }
                max=max+grid[i][j];
            }
        }
        return max;
    }
}
