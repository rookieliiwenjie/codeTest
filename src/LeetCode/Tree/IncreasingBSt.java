package LeetCode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/9 7:11 下午
 * @Description:
 */
public class IncreasingBSt {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);
        root.left = rootLeft;
        TreeNode rootRightLeft = new TreeNode(15);
        TreeNode rootRightRight = new TreeNode(7);
        rootRight.right = rootRightRight;
        rootRight.left = rootRightLeft;
        root.right = rootRight;
        increasingBST(root);
        System.out.println("root = " + root);

    }

    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        getTreeNode(root, list);
        Collections.sort(list);
        TreeNode newRoot = new TreeNode();
        for (int i = list.size() - 1; i >= 0; i--) {
            TreeNode right = new TreeNode();
            newRoot.val = list.get(i);
            right.right = newRoot;
            newRoot = right;
        }
        return newRoot.right;

    }

    public static void getTreeNode(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        getTreeNode(node.left, list);
        list.add(node.val);
        getTreeNode(node.right, list);
    }

//    public static TreeNode increasingBST2() {
//
//    }

}
