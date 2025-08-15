package LeetCode.everyDay;

import java.util.Arrays;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class GenerateMatrix {
    //    输入：n = 3
//    输出：[[1,2,3],
//          [8,9,4],
//          [7,6,5]]

    public static void main(String[] args) {
        double f = 0.2;
        System.out.println(0.2*2);
//        int[][] ints = generateMatrix(3);
//        System.out.println(Arrays.deepToString(ints));
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int i = 0;
        int j = 0;
        //x y
        int[][] round = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//右 下 左 上
        int index = 0;
        for (int f = 1; f <= n * n; f++) {
            int nextX = i + round[index][0];
            int nextY = j + round[index][1];
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || result[nextX][nextY] != 0) {
                index = (index + 1) % 4;
            }
            result[i][j] = f;
            i += round[index][0];
            j += round[index][1];
        }
        return result;
    }

    public int[][] generateMatrix2(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }


}
