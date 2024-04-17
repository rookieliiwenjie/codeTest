package LeetCode;

/**
 * @Author rookie.li
 * @create 2020/11/17
 */
public class Nim {
    /**
     * 桌子上有一堆石头。
     * 你们轮流进行自己的回合，你作为先手。
     * 每一回合，轮到的人拿掉1 - 3 块石头。
     * 拿掉最后一块石头的人就是获胜者。
     * 假设你们每一步都是最优解。请编写一个函数，
     * 来判断你是否可以在给定石头数量为 n 的情况下赢得游戏
     * 。如果可以赢，返回 true；否则，返回 false 。
     */
    public static void main(String[] args) {

    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    /**
     *
     * @param oldNumber 数量
     * @param outNumbder 拿出的数量
     * @return
     */

}
