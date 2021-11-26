package com.company.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，
 * 同一层的节点按照从左到右的顺序打印。
 *
 * @author rookie.li
 * @date 2021-09-24 23:08
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 */
public class levelOrderOne {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);
        root.left = rootLeft;
        root.right = rootRight;
        TreeNode rootRightLeft = new TreeNode(15);
        TreeNode rootRightRight = new TreeNode(7);
        rootRight.right = rootRightRight;
        rootRight.left = rootRightLeft;
        int[] list = levelOrder(root);
        for (int i:
             list) {
            System.out.println("i = " + i);
        }
    }

    public static int[] levelOrder(TreeNode root) {
        List<Integer> newList = new ArrayList<Integer>();
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                newList.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        int[] ints = newList.stream().mapToInt(Integer::valueOf).toArray();
        return ints;
    }
}
