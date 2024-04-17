package LeetCode.ArrayDemo;

public class Rotate {
    public static void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int newArr[][] = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = m-1; j >= 0; j--) {
                newArr[i][m-j-1] = matrix[j][i];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                matrix[i][j] = newArr[i][j];
            }
        }
    }

    public static void rotate2(int[][] matrix) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            for (int j = m-1; j >= 0; j--) {
                int tmep = matrix[j][i];
                matrix[j][i] = matrix[i][m-j-1];
                matrix[i][m-j-1] = tmep;
            }
        }

    }

    public static void main(String[] args) {
        rotate2(new int[][]{{1,2,3},
                            {4,5,6},
                            {7,8,9}});
        System.out.println();
    }

}
