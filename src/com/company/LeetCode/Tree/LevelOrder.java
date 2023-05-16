package com.company.LeetCode.Tree;

import java.util.*;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/15 7:30 下午
 * @Description:
 */
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rootleft = new TreeNode(9);
        TreeNode rootright = new TreeNode(20);

        TreeNode rootrightleft = new TreeNode(15);
        TreeNode rootrightright = new TreeNode(7);
        rootright.right = rootrightright;
        rootright.left = rootrightleft;
        root.left = rootleft;
        root.right = rootright;
       // levelOrder(root);
        System.out.println("rootrightright = " +  maxDepth2(root));

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            List<Integer> newArr = new ArrayList<>();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.poll();
                newArr.add(pop.val);
                if (pop.left != null) {
                    stack.offer(pop.left);
                }
                if (pop.right != null) {
                    stack.offer(pop.right);
                }
            }
            arr.add(newArr);

        }
        return arr;


    }

    public static int maxDepth2(TreeNode root) {
        int  max = 0;
        if (root == null) {
            return max;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()){
            int lenght = treeNodes.size();
            for (int i = 0; i < lenght; i++) {
                TreeNode poll = treeNodes.poll();
                if(poll.left!=null){
                    treeNodes.offer(poll.left);
                }
                if(poll.right!=null){
                    treeNodes.offer(poll.right);
                }
            }
            max =max+1;
        }
        return max;
    }
    public List<List<Integer>> levelOrder3(TreeNode root){
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }

}
