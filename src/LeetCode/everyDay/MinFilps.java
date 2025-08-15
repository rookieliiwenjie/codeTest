package LeetCode.everyDay;

public class MinFilps {

    public static void main(String[] args) {
        MinFilps minFilps = new MinFilps();
        //[[0,1],[0,1],[0,0]]
        int[][] grid = {{0, 1}, {0, 1}, {0, 0}};
//        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(minFilps.minFlips(grid));
    }

    public int minFlips(int[][] grid) {
        int hangCount = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                if (grid[i][left] != grid[i][right]) {
                    hangCount++;
                }
                left++;
                right--;
            }
        }
        int leiCount = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            while (left < right) {
                if (grid[left][i] != grid[right][i]) {
                    leiCount++;
                }
                left++;
                right--;
            }
        }
        return Math.min(hangCount, leiCount);
    }


    public int minFlips2(int[][] grid) {
        int hangCount = 0;
        int m = grid.length;
        int n = grid[0].length;
        //1的总个数
        int sumNum = 0;
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                if (grid[i][left] != grid[i][right]) {
                    hangCount++;
                }
                if (grid[i][left] == 1) {
                    sumNum++;
                }
                if (grid[i][right] == 1) {
                    sumNum++;
                }
                left++;
                right--;
            }
        }
        int leiCount = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            while (left < right) {
                if (grid[left][i] != grid[right][i]) {
                    leiCount++;
                }
                if (grid[left][i] == 1) {
                    sumNum++;
                }
                if (grid[right][i] == 1) {
                    sumNum++;
                }
                left++;
                right--;
            }
        }
        if (sumNum % 2 != 0) {

        }
        return Math.min(hangCount, leiCount);
    }
}
