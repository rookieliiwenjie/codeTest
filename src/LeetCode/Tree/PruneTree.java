package LeetCode.Tree;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/8 11:11 上午
 * @Description:
 */
public class PruneTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(0);
        root.right = right;
        TreeNode rightLeft = new TreeNode(0);
        TreeNode rightRight = new TreeNode(1);
        right.left = rightLeft;
        right.right = rightRight;
        pruneTree(root);

    }

    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if ( root.left == null &&  root.right == null && root.val == 0) {
            root = null;
        }
        return root;
    }



}
