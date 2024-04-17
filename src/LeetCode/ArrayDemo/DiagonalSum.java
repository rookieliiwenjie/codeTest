package LeetCode.ArrayDemo;

public class DiagonalSum {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new DiagonalSum().diagonalSum(mat));
    }

    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int m = mat.length;
        for (int i = 0; i < m; i++) {
            if (i == (m - 1 - i)) {
                sum += mat[i][i];
            } else {
                sum += mat[i][i] + mat[i][m - 1 - i];
            }
        }
        return sum;
    }
}
