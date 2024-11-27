package LeetCode.everyDay;

public class NumberOfAlternatingGroups {

    public int numberOfAlternatingGroups(int colors[]) {
        int res = 0;
        for (int i = 0; i < colors.length; i++) {
            int left = 0;
            int right = 0;
            if (i == 0) {
                left = colors.length - 1;
                right = i + 1;
            } else if (i == colors.length - 1) {
                left = i - 1;
                right = 0;
            } else {
                left = i - 1;
                right = i + 1;
            }
            if (colors[i] != colors[left] && colors[i] != colors[right]) {
                res++;
            }
        }
        return res;
    }

    public int numberOfAlternatingGroups2(int[] colors) {
        int n = colors.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[(i - 1 + n) % n] && colors[i] != colors[(i + 1) % n]) {
                res += 1;
            }
        }
        return res;
    }
//    给你一个整数数组 colors 和一个整数 k ，colors表示一个由红色和蓝色瓷砖组成的环，第 i 块瓷砖的颜色为 colors[i] ：
//
//    colors[i] == 0 表示第 i 块瓷砖的颜色是 红色 。
//    colors[i] == 1 表示第 i 块瓷砖的颜色是 蓝色 。
//    环中连续 k 块瓷砖的颜色如果是 交替 颜色（也就是说除了第一块和最后一块瓷砖以外，中间瓷砖的颜色与它 左边 和 右边 的颜色都不同），那么它被称为一个 交替 组。
//
//    请你返回 交替 组的数目。
//
//    注意 ，由于 colors 表示一个 环 ，第一块 瓷砖和 最后一块 瓷砖是相邻的。







}
