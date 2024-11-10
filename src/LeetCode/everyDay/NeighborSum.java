package LeetCode.everyDay;

import java.util.HashMap;

public class NeighborSum {
    int grid[][];
    HashMap<Integer, int[]> hashMap = new HashMap();
    int dirIndex[][][] = { { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } },
            { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } } };

    public NeighborSum(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[] index = { i, j };
                hashMap.put(grid[i][j], index);

            }
        }
        this.grid = grid;
    }

    public int adjacentSum(int value) {
        // 右 下 左 上
        return getSum(value, 0);

    }

    private int getSum(int value, int indexNum) {
        int[][] index = dirIndex[indexNum];
        int sum = 0;
        int gridL = grid.length;
        int valueIndx[] = hashMap.get(value);
        for (int i = 0; i < index.length; i++) {
            int curIndex[] = index[i];
            if (curIndex[0] + valueIndx[0] >= 0 && curIndex[0] + valueIndx[0] < gridL && curIndex[1] + valueIndx[1] >= 0
                    && curIndex[1] + valueIndx[1] < gridL) {
                sum += this.grid[curIndex[0] + valueIndx[0]][curIndex[1] + valueIndx[1]];
            }
        }
        return sum;
    }

    public int diagonalSum(int value) {
        // 左上 左下 右上
        return getSum(value, 1);
    }
}