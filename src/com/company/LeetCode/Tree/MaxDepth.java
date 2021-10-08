package com.company.LeetCode.Tree;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-10-07 21:51
 */
public class MaxDepth {
//    public int maxDepth(TreeNode root) {
//
//    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.right), maxDepth2(root.left)) + 1;

    }
}
