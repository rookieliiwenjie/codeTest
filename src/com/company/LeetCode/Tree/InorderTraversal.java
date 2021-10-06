package com.company.LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-09-27 00:04
 */
public class InorderTraversal {
    /**
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     * 左根右
     *
     * @param root
     * @return
     */
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode headRigth = new TreeNode(2);
        head.right = headRigth;
        TreeNode headRigthLeft = new TreeNode(3);
        headRigth.left = headRigthLeft;
        List<Integer> integers = inorderTraversal(head);
        System.out.println("integers = " + integers);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }
    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


}
