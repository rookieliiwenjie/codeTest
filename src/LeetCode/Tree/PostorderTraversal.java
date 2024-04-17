package LeetCode.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 在此填写类的用途、注意事项等
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * @author rookie.li
 * @date 2021-10-12 18:09
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //左右根
        findTreeNode(root, list);
        return list;
    }

    private static void findTreeNode(TreeNode node, List<Integer> list) {
        if (node != null) {
            findTreeNode(node.left, list);
            findTreeNode(node.right, list);
            list.add(node.val);
        }

    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }



}
