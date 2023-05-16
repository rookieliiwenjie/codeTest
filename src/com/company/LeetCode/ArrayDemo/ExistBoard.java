package com.company.LeetCode.ArrayDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/16 9:57 上午
 * @Description:
 */
public class ExistBoard {
    /**
     * 我对这个的疑问有两个点
     * 1、如何判断是否使用过 ----  同时每次循环完成后，进行还原操作。可以同步一个boolean的数组去维护，每一次进入都是对 i j 这个点位进行的一个判断，判断他路径上有没有对应的一个路径
     * 2、如果出现不同的路径，那么我如何回归到下一个路径 ------对每一个i，j的点位都进行一个判断，判断路径上是否有对应的一个word，
     * 3、回溯的是什么
     *
     * @param board
     * @param word
     * @return
     */

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] check = new boolean[m][n];
        boolean isExist;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                isExist = check2(check,i,j,board,word,0);
                if (isExist) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void deom(boolean[][] check){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                check[i][j] = true;
            }
        }
    }
    public static void main(String[] args) {
        boolean[][] check = new boolean[5][5];
        System.out.println("check = " + check);
        for (int i = 0; i < 5; i++) {
            deom(check);

        }


    }




    public static boolean exist2(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                //每一次进入都是对 i j 这个点位进行的一个判断，判断他路径上有没有对应的一个路径
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check2(boolean[][] checkBoolean,int i ,int j, char[][]board, String word,int wordIndex) {
        if (board[i][j] != word.charAt(wordIndex)) {
            return false;
        } else if (wordIndex == (word.length() - 1)) {
            return true;
        }
        checkBoolean[i][j] = true;
        //维护一个转向表
        int [][] arr = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean result = false;
        for (int[] a : arr) {
            int iIdex = i + a[0];
            int jIdex = j + a[1];
            if (iIdex >= 0 && iIdex < checkBoolean.length  && jIdex >= 0 && jIdex < checkBoolean[0].length) {
                if(!checkBoolean[iIdex][jIdex]){
                    boolean flag = check2(checkBoolean, iIdex, jIdex, board, word, wordIndex + 1);
                    if (flag) {
                        result = true;
                        //这里break是因为如果某个路径对，但是下面不是联系的时候那么就会出问题
                        break;
                    }
                }
            }
        }
        //精髓每次无论是否可以都进行还原，减少空间复杂度
        checkBoolean[i][j] = false;
        return result;
    }
    public static boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        //数组长度代表 四个方向， 【x,y】代表 x 表示 x轴，y 表示 y轴，所以，0 表示 向前走一个，1。表示向后走一位， 2表示向下走一位 3表示向上走一位
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
