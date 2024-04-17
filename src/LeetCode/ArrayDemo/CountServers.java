package LeetCode.ArrayDemo;

public class CountServers {

    public static void main(String[] args) {
        CountServers countServers = new CountServers();
//        int[][] grid = {{1, 0}, {0, 1}};
        int[][] grid = {{1, 0}, {1, 1}};
        int i = countServers.countServers(grid);
        System.out.println(i);
    }

    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        int mFlag[] = new int[m];
        int nFlag[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    mFlag[i]++;
                    nFlag[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (mFlag[i] > 1 || nFlag[j] > 1)){
                    ++sum;
                }
            }
        }
        return sum;
    }
}
