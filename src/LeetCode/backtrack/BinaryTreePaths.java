package LeetCode.backtrack;

import LeetCode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.right = treeNode5;
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> strings = binaryTreePaths.binaryTreePaths(treeNode);

        System.out.println(strings);
        List<String> strings2 = binaryTreePaths.binaryTreePaths2(treeNode);
        System.out.println(strings2);
    }
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        getTreePath2(root, res, new StringBuilder());
        return res;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        getTreePath(root, res, new StringBuilder());
        return res;
    }


    public void getTreePath(TreeNode node, List<String> res, StringBuilder cur) {
        if (node.left == null && node.right == null) {
            cur.append(node.val);
            res.add(cur.toString());
            return;
        }
        cur.append(node.val);
        if (node.left != null) {
            StringBuilder temp = new StringBuilder(cur);
            temp.append("->");
            getTreePath(node.left, res, temp);
        }
        if (node.right != null) {
            StringBuilder righttep = new StringBuilder(cur);
            righttep.append("->");
            getTreePath(node.right, res, righttep);
        }
    }


    public void getTreePath2(TreeNode node, List<String> res, StringBuilder cur) {
        if (node.left == null && node.right == null) {
            cur.append(node.val);
            res.add(cur.toString());
            cur.deleteCharAt(cur.length() - 1);
            return;
        }
        cur.append(node.val);
        if (node.left != null) {
            cur.append("->");
            getTreePath2(node.left, res, cur);
        }
        if (node.right != null) {
            cur.append("->");
            getTreePath2(node.right, res, cur);
        }
    }
}
