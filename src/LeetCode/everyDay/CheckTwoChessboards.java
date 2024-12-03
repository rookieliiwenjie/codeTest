package LeetCode.everyDay;

import java.util.HashMap;

public class CheckTwoChessboards {
    /**
     * 给你两个字符串 coordinate1 和 coordinate2，代表 8 x 8 国际象棋棋盘上的两个方格的坐标。
     * <p>
     * 以下是棋盘的参考图。
     * 如果这两个方格颜色相同，返回 true，否则返回 false。
     * <p>
     * 坐标总是表示有效的棋盘方格。坐标的格式总是先字母（表示列），再数字（表示行）。
     * 示例 1：
     * 输入： coordinate1 = "a1", coordinate2 = "c3"
     * 输出： true
     * 解释：
     * 两个方格均为黑色。
     * 示例 2：
     * 输入： coordinate1 = "a1", coordinate2 = "h3"
     * 输出： false
     * 解释：
     * 方格 "a1" 是黑色，而 "h3" 是白色。
     */
    public static void main(String[] args) {
        CheckTwoChessboards checkTwoChessboards = new CheckTwoChessboards();
        String coordinate1 = "a7", coordinate2 = "a6";
        System.out.println(checkTwoChessboards.checkTwoChessboards2(coordinate1, coordinate2));
    }

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int[] arr = new int[9];
        // 奇数 1 黑 0 白
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i % 2;
        }
        char[] coorind1 = coordinate1.toCharArray();
        char[] coorind2 = coordinate2.toCharArray();
        //黑
        boolean coor1 = false;
        boolean coor2 = false;
        if (arr[coorind1[0] - 'a' + 1] == 1) {
            coor1 = coorind1[1] % 2 == 0;
        } else {
            coor1 = coorind1[1] % 2 != 0;
        }
        if (arr[coorind2[0] - 'a' + 1] == 1) {
            coor2 = coorind2[1] % 2 == 0;
        } else {
            coor2 = coorind2[1] % 2 != 0;
        }
        return coor1 == coor2;
    }

    public boolean checkTwoChessboards2(String coordinate1, String coordinate2) {
        // 两个坐标的差值是偶数，那么颜色相同
        if ((coordinate2.charAt(0) - coordinate1.charAt(0)) % 2 == 0) {
            return (coordinate2.charAt(1) - coordinate1.charAt(1)) % 2 == 0;
        }
        return (coordinate2.charAt(1) - coordinate1.charAt(1)) % 2 != 0;
    }
}
