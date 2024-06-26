package LeetCode;

/**
 你和你的朋友，两个人一起玩Nim 游戏：
 桌子上有一堆石头。
 你们轮流进行自己的回合，你作为先手。
 每一回合，轮到的人拿掉1 - 3 块石头。
 拿掉最后一块石头的人就是获胜者。
 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
 示例 1：
 输入：n = 4
 输出：false 
 解释：如果堆中有 4 块石头，那么你永远不会赢得比赛；
     因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 示例 2：

 输入：n = 1
 输出：true
 示例 3：

 输入：n = 2
 输出：true
 链接：https://leetcode-cn.com/problems/nim-game
 *
 * @author rookie.li
 * @date 2021-09-18 18:36
 */
public class canWinNim {

    public boolean canWinNim(int n) {
        return n%4!=0;
    }
}
