package LeetCode;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-09-21 20:21
 */
public class FindNumberIn2DArray {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println("nums = " + nums.length);
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int x = 0;
        if (matrix.length <= 0) {
            return false;
        }
        int y = matrix[x].length - 1;
        while (x < matrix.length - 1 && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }

    public static boolean findNumberIn2DArray1(int[][] matrix, int target) {

        if (matrix.length <= 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
