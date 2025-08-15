package LeetCode.everyDay;

public class UniquePathsWithObstacles {
    /**
     * 给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。
     * 机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。
     * 机器人每次只能向下或者向右移动一步。
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
     * 返回机器人能够到达右下角的不同路径数量。
     * @param obstacleGrid
     * @return
     * 在这个也要回溯
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int res = 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return res;
        }

        return res;
    }
}
