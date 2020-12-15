package com.company.LaoHan.LeetCodeTree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lwj32 on 2020/7/3.
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 */
public class PreOrderTree {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7= new TreeNode(7);
        treeNode.right = treeNode2;
        treeNode.left = treeNode4;
        treeNode4.left = treeNode6;
        treeNode4.right = treeNode7;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode5;
        PreOrderTree preOrderTree = new PreOrderTree();
        List<Integer> list = preOrderTree.midraversa2(treeNode);
        for (int li : list) {
            System.out.println("li = " + li);
        }
    }

    List<Integer> preOrderList = new ArrayList<>();

    /*public List<Integer> preorderTraversal(TreeNode root) {
            preOrderList.add(root.val);
            if (root.left != null) {
                preorderTraversal(root.left);
            }
            if (root.right != null) {
                preorderTraversal(root.right);
            }
        return preOrderList;


    }*/
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrderList.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left);
        }
        if (root.right != null) {
            preorderTraversal(root.right);
        }
        return preOrderList;


    }
    public List<Integer> midTraversal2(TreeNode root) {
        if (root.left != null) {
            midTraversal2(root.left);
        }
        preOrderList.add(root.val);
        if (root.right != null) {
            midTraversal2(root.right);
        }
      return preOrderList;
    }
    public List<Integer> preorderTraversa2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> output = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            //栈的最后一个元素还是要符合根左右的条件，先去遍历
            TreeNode treeNode = stack.pollLast();
            //将各个子树的根插入到output中
            output.add(treeNode.val);
            if(treeNode.right!=null){
                stack.add(treeNode.right);
            }
            if(treeNode.left!=null){
                stack.add(treeNode.left);
            }
        }
        return output;
    }
    public List<Integer> midraversa2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> output = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            //栈的最后一个元素还是要符合根左右的条件，先去遍历
            TreeNode treeNode = stack.pollLast();

            if(treeNode.right!=null){
                stack.add(root.right);
            }

            //将各个子树的根插入到output中
            output.add(root.val);
            if(treeNode.left!=null){
                stack.add(root.left);
            }
        }
        return output;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}