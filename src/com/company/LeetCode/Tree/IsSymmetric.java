package com.company.LeetCode.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 在此填写类的用途、注意事项等
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2  2
 * / \ / \
 * 3 4 4 3
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2  2
 * \  \
 * 3  3
 * <p>
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<TreeNode> list = new LinkedList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode pop = deque.pop();
                list.add(pop);
                if (pop.left != null) {
                    deque.add(pop.left);
                } else if (pop.right != null) {
                    deque.add(pop.right);
                }
            }
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                TreeNode leftList = list.get(left);
                TreeNode rightList = list.get(right);
                if (leftList.val != rightList.val ||
                        leftList.left.val != rightList.right.val ||
                        leftList.right.val != rightList.left.val) {
                    return false;
                }
                left++;
                right--;
            }

        }
        return true;
    }
    public boolean isSymmetricTwo(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }


}
