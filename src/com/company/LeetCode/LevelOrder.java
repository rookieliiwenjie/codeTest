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
    public static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("mirrorTree(root) = " + mirrorTree(root));
    }
    public static TreeNode  mirrorTree(TreeNode root){
        return mirror(root);
    }
    public static TreeNode mirror(TreeNode root){
        if (root==null) {
           return null;
        }
        TreeNode left  = mirror(root.left);
        TreeNode right  = mirror(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    public static boolean isSymmetric(TreeNode root){
        return symmetric(root,root);
    }

    public static boolean symmetric(TreeNode left,TreeNode right){
      if(left==null && right==null){
          return true;
      }
      if(left==null || right==null){
        return false;
      }
      return  left.val == right.val && symmetric(left.left,right.right) && symmetric(left.right,right.left);
    }
}
