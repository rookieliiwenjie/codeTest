package LeetCode.everyDay;

public class MaximumPoints {
    /**
     * 一棵由 n 个节点组成的无向树，以 0  为根节点，
     * 节点编号从 0 到 n - 1 。给你一个长度为 n - 1 的二维 整数 数组 edges
     * ，其中 edges[i] = [ai, bi] 表示在树上的节点 ai 和 bi 之间存在一条边。
     * 另给你一个下标从 0 开始、长度为 n 的数组 coins 和一个整数 k ，其中 coins[i] 表示节点 i 处的金币数量。
     * <p>
     * 从根节点开始，你必须收集所有金币。要想收集节点上的金币，
     * 必须先收集该节点的祖先节点上的金币。
     * <p>
     * 节点 i 上的金币可以用下述方法之一进行收集：
     * <p>
     * 收集所有金币，得到共计 coins[i] - k 点积分。如果 coins[i] - k
     * 是负数，你将会失去 abs(coins[i] - k) 点积分。
     * 收集所有金币，得到共计 floor(coins[i] / 2) 点积分。如果采用这种方法，
     * 节点 i 子树中所有节点 j 的金币数 coins[j] 将会减少至 floor(coins[j] / 2) 。
     * 返回收集 所有 树节点的金币之后可以获得的最大积分。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     *
     * @param edges
     * @param coins
     * @param k
     * @return
     */
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        return 0;
    }
}
