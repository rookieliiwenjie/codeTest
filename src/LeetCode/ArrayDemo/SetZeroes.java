package LeetCode.ArrayDemo;

import java.util.ArrayList;
import java.util.List;

public class SetZeroes {
    public static void main(String[] args) {
//        int[][] arr = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        new SetZeroes().setZeroes2(arr);
//        System.out.println(arr);
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //快速排序arr的方法


    }

    //生成一个快速排序数组的方法
    public int[] sortArr(int arr[]) {
        return arr;
    }

    /**
     * 很愚蠢的解法，应该早就想到，只需要记录 row clo 就可以
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        List<String> strings = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    strings.add(i + "_" + j);
                }
            }
        }
        for (String string : strings) {
            String[] split = string.split("_");
            int row = Integer.parseInt(split[0]);
            int col = Integer.parseInt(split[1]);
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
            for (int i = 0; i < n; i++) {
                matrix[row][i] = 0;
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row[] = new boolean[m];
        boolean col[] = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 原地空间
     *
     * @param matrix
     */
    public void setZeroe3(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 用第一行和第一列来记录
        for (int i = 0; i <row; i++) {

        }
        for (int i = 0; i <row; i++) {

        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
    }
}
