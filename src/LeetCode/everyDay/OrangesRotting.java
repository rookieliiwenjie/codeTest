package LeetCode.everyDay;

import java.util.*;

public class OrangesRotting {
    public int orangesRotting2(int[][] grid) {
        int minSum = 0;
        //行
        int gridN = grid.length;
        //列
        int gridM = grid[0].length;
        int[][] arr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < gridN; i++) {
            for (int j = 0; j < gridM; j++) {
                if (grid[i][j] >= 2) {
                    for (int k = 0; k < arr.length; k++) {
                        int mIndex = i + arr[k][0];
                        int nIndex = i + arr[k][1];
                        if (mIndex >= 0 && nIndex >= 0) {

                        }
                    }
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        OrangesRotting orangesRotting = new OrangesRotting();
        int[][] grid = {{2, 1, 1},
                        {1, 1, 0},
                        {0, 1, 1}};

//        int[][] grid = {{2, 1, 1},
//                        {0, 1, 1},
//                        {1, 0, 1}};
//         int[][] grid = {{0, 2}};
//        int[][] grid = {{0}};
//        int[][] grid = {{1, 2}};
//        int[][] grid = {{1},
//                {2},
//                {1},
//                {2}};
        int i = orangesRotting.orangesRotting3(grid);
        System.out.println(i);


    }

    public int orangesRotting(int[][] grid) {
        int minSum = 0;
        int gridN = grid.length;
        int gridM = grid[0].length;
        int[][] arr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < gridN; i++) {
            for (int j = 0; j < gridM; j++) {
                if (grid[i][j] == 2) {
                    int[] indexArr = {i, j};
                    queue.add(indexArr);
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] remove = queue.remove();
                size--;
                for (int k = 0; k < arr.length; k++) {
                    int nIndex = remove[0] + arr[k][0];
                    int mIndex = remove[1] + arr[k][1];
                    if (mIndex >= 0 && mIndex < gridM && nIndex >= 0 && nIndex < gridN && grid[nIndex][mIndex] == 1) {
                        grid[nIndex][mIndex] = 2;
                        queue.offer(new int[]{nIndex, mIndex});
                    }
                }
            }
            minSum++;
        }

        for (int[] ints : grid) {
            for (int j = 0; j < gridM; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        return (minSum == 0 ? minSum : minSum - 1);
    }

    /**
     * 官方版本
     * @param grid
     * @return
     */
    public int orangesRotting3(int[][] grid) {
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};
        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        Map<Integer, Integer> depth = new HashMap<Integer, Integer>();
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }
        for (int[] row : grid) {
            for (int v : row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

}
