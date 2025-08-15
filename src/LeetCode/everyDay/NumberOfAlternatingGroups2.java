package LeetCode.everyDay;

public class NumberOfAlternatingGroups2 {


    //    给你一个整数数组 colors 和一个整数 k ，
//    colors表示一个由红色和蓝色瓷砖组成的环，第 i 块瓷砖的颜色为 colors[i] ：
//
//    colors[i] == 0 表示第 i 块瓷砖的颜色是 红色 。
//    colors[i] == 1 表示第 i 块瓷砖的颜色是 蓝色 。
//    环中连续 k 块瓷砖的颜色如果是 交替 颜色（
//    也就是说除了第一块和最后一块瓷砖以外，中间瓷砖的颜色与它 左边 和 右边 的颜色都不同），那么它被称为一个 交替 组。
//
//    请你返回 交替 组的数目。
//
//    注意 ，由于 colors 表示一个 环 ，第一块 瓷砖和 最后一块 瓷砖是相邻的。
    public static void main(String[] args) {
        int co[] = {0, 1, 0, 0, 1, 0, 1};
        int k = 6;
        NumberOfAlternatingGroups2 numberOfAlternatingGroups = new NumberOfAlternatingGroups2();
        int i = numberOfAlternatingGroups.numberOfAlternatingGroups(co, k);
        System.out.println(i);
    }

    /**
     * 遍历数组 colors，用一个整数 cnt 代表遍历到当前元素时，
     * 已经有的连续交替瓷砖的数量。如果当前元素与前一个元素不同，
     * 则将 cnt 加 1，否则将其置为 1。 如果当前 cnt 大于等于 k，
     * 则将结果加 1。注意到瓷砖是环形的，因此，在遍历到第一个数时，
     * 我们就需要知道当前的 cnt。为了得到初始的 cnt 值，我
     * 们需要将遍历的起点往前推 k−2 步，这样在遍历到数组的第一个元素时，
     * 我们就可以知道当前是否有 k 块连续的交替瓷砖。最后返回结果。
     *
     * @param colors
     * @param k
     * @return
     */
    public int numberOfAlternatin(int[] colors, int k) {
        int n = colors.length;
        int res = 0, cnt = 1;
        for (int i = -k + 2; i < n; i++) {
            if (colors[(i + n) % n] != colors[(i - 1 + n) % n]) {
                cnt += 1;
            } else {
                cnt = 1;
            }
            if (cnt >= k) {
                res += 1;
            }
        }
        return res;


    }


    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int res = 0, cnt = 1;
        for (int i = -k + 2; i < n; i++) {
            if (colors[(i + n) % n] != colors[(i + 1 + n) % n]) {
                cnt += 1;
            } else {
                cnt = 1;
            }
            if (cnt >= k) {
                res += 1;
            }
        }
        return res;
    }


}
