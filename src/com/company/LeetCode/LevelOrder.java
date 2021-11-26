package com.company.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下打印二叉树 II
 *
 * @author rookie.li
 * @date 2021-09-21 20:17
 */

/**
 * 解题思路
 */
public class LevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> leverList = new ArrayList<>();
        if (root == null) {
            return leverList;
        }
        TreeNode head = root;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null || right != null) {
            List<Integer> listLeftAndRight = new ArrayList<>();
            if (left != null) {
                listLeftAndRight.add(left.val);
                left = left.left;
            }
            if (right != null) {
                listLeftAndRight.add(right.val);
            }

        }
        leverList.add(list);
        return leverList;
    }

}
