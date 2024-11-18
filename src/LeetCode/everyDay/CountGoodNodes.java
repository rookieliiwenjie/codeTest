package LeetCode.everyDay;

import java.util.*;

/**
 * 好节点的数量
 */
public class CountGoodNodes {
    /**
     * 现有一棵 无向 树，树中包含 n 个节点，按从 0 到 n - 1 标记。树的根节点是节点 0 。
     * 给你一个长度为 n - 1 的二维整数数组 edges，其中 edges[i] = [ai, bi]
     * 表示树中节点 ai 与节点 bi 之间存在一条边。
     * <p>
     * 如果一个节点的所有子节点为根的子树包含的节点数相同，则认为该节点是一个 好节点。
     * <p>
     * 返回给定树中 好节点 的数量。
     * <p>
     * 子树 指的是一个节点以及它所有后代节点构成的一棵树。
     *
     * @param edges
     * @return
     */

    public static void main(String[] args) {
        CountGoodNodes countGoodNodes = new CountGoodNodes();
//        int end[][] = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
//        int end[][] = {{6, 0}, {1, 0}, {5, 1}, {2, 5}, {3, 1}, {4, 3}};
        int end[][] = {{1, 0}, {3, 0}, {2, 3}};
        int i = countGoodNodes.countGoodNodes(end);
        System.out.println(i);
    }

    int goodCNodes = 0;
    List<Integer> dealNode = new ArrayList<>();

    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1; // Total number of nodes
        if (n == 1) return 1; // Only one node, it's trivially good

        // Step 1: Build adjacency list
        HashMap<Integer, List<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            tree.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            tree.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        dealNode.add(0);
        sumNum(tree, tree.get(0));
        return goodCNodes;
    }

    public int sumNum(HashMap<Integer, List<Integer>> hashMap, List<Integer> childList) {
        //本层
        int sum = 0;
        int treeSize = 0;
        boolean flag = true;
        if (childList == null || childList.size() <= 0) {
            return 1;
        }
        for (Integer key : childList) {
            if (dealNode.contains(key)) {
                continue;
            }
            dealNode.add(key);
            List<Integer> list = hashMap.get(key);
            if (list == null || list.size() <= 0) {
                goodCNodes++;
            }
            int i = sumNum(hashMap, list);
            int childSum = i == 0 ? 1 : i;
            treeSize += childSum;
            if (sum != 0) {
                if (childSum != sum) {
                    flag = false;
                }
            } else {
                sum = childSum;
            }
        }
        if (flag) {
            goodCNodes++;
        }
        return treeSize;
    }

}
