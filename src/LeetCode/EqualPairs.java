package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/6 2:23 下午
 * @Description:
 */
public class EqualPairs {
    public static void main(String[] args) {
        int[][] arr = {{3, 2, 1},
                {1, 7, 6},
                {2, 7, 7}};
//                int[][] arr = {{11,1},
//                {1,11}};

//        int arr[][] = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        equalPairs5(arr);
    }

    public static int equalPairs(int[][] grid) {
        int x = grid.length;
        HashMap<String, Integer> list = new HashMap<>();
        HashMap<String, Integer> listy = new HashMap<>();
        for (int i = 0; i < x; i++) {
            StringBuilder xString = new StringBuilder();
            StringBuilder yString = new StringBuilder();
            for (int j = 0; j < x; j++) {
                xString.append(grid[i][j]).append(",");
                yString.append(grid[j][i]).append(",");
            }
            list.put(xString.toString(), list.getOrDefault(xString.toString(), 0) + 1);
            listy.put(yString.toString(), listy.getOrDefault(yString.toString(), 0) + 1);
        }
        int sum = 0;
        for (String listnew : list.keySet()) {
            if (listy.containsKey(listnew)) {
                sum += listy.get(listnew) * list.get(listnew);
            }
        }
        return sum;
    }


    public static int equalPairs5(int[][] grid) {
        int x = grid.length;
        HashMap<List<Integer>, Integer> list = new HashMap<>();
        for (int[] value : grid) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int j = 0; j < x; j++) {
                arr.add(value[j]);
            }
            list.put(arr, list.getOrDefault(arr, 0) + 1);
        }
        int sum = 0;
        for (int j = 0; j < x; j++) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int[] ints : grid) {
                arr.add(ints[j]);
            }
            if(list.containsKey(arr)){
                sum+=list.get(arr);
            }
        }
        return sum;
    }

    public int equalPairs4(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> cnt = new HashMap<List<Integer>, Integer>();
        for (int[] row : grid) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int num : row) {
                arr.add(num);
            }
            cnt.put(arr, cnt.getOrDefault(arr, 0) + 1);
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> arr = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                arr.add(grid[i][j]);
            }
            if (cnt.containsKey(arr)) {
                res += cnt.get(arr);
            }
        }
        return res;
    }

    public int equalPairs3(int[][] grid) {
        int res = 0, n = grid.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (equal(row, col, n, grid)) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean equal(int row, int col, int n, int[][] grid) {
        for (int i = 0; i < n; i++) {
            if (grid[row][i] != grid[i][col]) {
                return false;
            }
        }
        return true;
    }
}
