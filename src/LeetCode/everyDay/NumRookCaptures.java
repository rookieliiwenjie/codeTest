package LeetCode.everyDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumRookCaptures {
    /**
     * 给定一个 8 x 8 的棋盘，只有一个 白色的车，用字符 'R' 表示。
     * 棋盘上还可能存在白色的象 'B' 以及黑色的卒 'p'。空方块用字符 '.' 表示。
     * <p>
     * 车可以按水平或竖直方向（上，下，左，右）
     * 移动任意个方格直到它遇到另一个棋子或棋盘的边界。如果它能够在一次移动中移动到棋子的方格，则能够 吃掉 棋子。
     * <p>
     * 注意：车不能穿过其它棋子，比如象和卒。这意味着如果有其它棋子挡住了路径，车就不能够吃掉棋子。
     * <p>
     * 返回白车将能 吃掉 的 卒的数量。
     *
     * @param board
     * @return [[".",".",".",".",".",".",".","."],
     * [".",".",".","p",".",".",".","."],
     * [".",".",".","p",".",".",".","."],
     * ["p","p",".","R",".","p","B","."],
     * [".",".",".",".",".",".",".","."],
     * [".",".",".","B",".",".",".","."],
     * [".",".",".","p",".",".",".","."],
     * [".",".",".",".",".",".",".","."]]
     * 输出：3
     */
    public static void main(String[] args) {
        NumRookCaptures numRookCaptures = new NumRookCaptures();
//        char[][] board = {{'.','.','.','.','.','.','.','.'},
//                        {'.','.','.','p','.','.','.','.'},
//                        {'.','.','.','R','.','.','.','p'},
//                        {'.','.','.','.','.','.','.','.'},
//                        {'.','.','.','.','.','.','.','.'},
//                        {'.','.','.','p','.','.','.','.'},
//                        {'.','.','.','.','.','.','.','.'},
//                        {'.','.','.','.','.','.','.','.'}};
        char board[][] = {{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', 'B', 'B', 'B', 'B', 'B', '.'},
                {'.', 'p', 'B', 'p', 'p', 'p', 'B', 'p'},
                {'.', 'p', 'B', 'p', 'R', 'p', 'B', 'p'},
                {'.', 'p', 'B', 'p', 'p', 'p', 'B', 'p'},
                {'.', '.', 'B', 'B', 'B', 'B', 'B', '.'},
                {'.', '.', '.', 'p', 'p', 'p', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(numRookCaptures.numRookCaptures(board));
    }

    public int numRookCaptures(char[][] board) {
        int[] Rindex = new int[2];
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if ('R' == board[x][y]) {
                    Rindex = new int[]{x, y};
                }
            }
        }
        int x = Rindex[0];
        int y = Rindex[1];
        int sum = 0;
        for (int left = y - 1, right = y + 1; left >= 0 || right < 8; left--, right++) {
            if (left >= 0) {
                if (board[x][left] == 'B') {
                    left = -1;
                } else if (board[x][left] == 'p') {
                    sum++;
                    left = -1;
                }
            }
            if (right < 8) {
                if (board[x][right] == 'B') {
                    right = 9;
                } else if (board[x][right] == 'p') {
                    sum++;
                    right = 9;
                }
            }
        }
        for (int top = x - 1, down = x + 1; top >= 0 || down < 8; top--, down++) {
            if (top >= 0) {
                if (board[top][y] == 'B') {
                    top = -1;
                } else if (board[top][y] == 'p') {
                    sum++;
                    top = -1;
                }
            }
            if (down < 8) {
                if (board[down][y] == 'B') {
                    down = 9;
                } else if (board[down][y] == 'p') {
                    sum++;
                    down = 9;
                }
            }
        }
        return sum;

    }

    public int numRookCapturesPlus(char[][] board) {
        int[] Rindex = new int[2];
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if ('R' == board[x][y]) {
                    Rindex = new int[]{x, y};
                }
            }
        }
        int x = Rindex[0];
        int y = Rindex[1];
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int step=0;;step++){

            }
        }
        return sum;

    }

    class Solution {
        public int numRookCaptures(char[][] board) {
            int cnt = 0, st = 0, ed = 0;
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (board[i][j] == 'R') {
                        st = i;
                        ed = j;
                        break;
                    }
                }
            }
            //这里是精髓4个方向
            for (int i = 0; i < 4; ++i) {
                for (int step = 0; ; ++step) {
                    int tx = st + step * dx[i];
                    int ty = ed + step * dy[i];
                    if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') {
                        break;
                    }
                    if (board[tx][ty] == 'p') {
                        cnt++;
                        break;
                    }
                }
            }
            return cnt;
        }
    }

}
