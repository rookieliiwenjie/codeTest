package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpairalOrder {
    //m行n列
    public List<Integer> spiralOrder2(int[][] matrix) {
        //
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;
        int arr[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> list = new ArrayList<>();
        int index = 0;
        int row = 0;
        int cl = 0;
        boolean visit[][] = new boolean[m][n];
        for (int i = 0; i < total; i++) {
            list.add(matrix[row][cl]);
            visit[row][cl] = true;
            int nextRow = row + arr[index][0], nextCol = cl + arr[index][1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visit[nextRow][nextCol]) {
                index = (index + 1) % 4;
            }
            row += arr[index][0];
            cl += arr[index][1];
        }
        return list;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int top = 0, bottom = rows - 1;
        int left = 0;
        int right = columns - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return order;
    }
}
