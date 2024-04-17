package LeetCode.Tree;

/**
 * @author rookie.li
 * @date 2021-10-12 17:04
 */
public class IsBalanced {

    public static int getTreeLenght(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1 + getTreeLenght(root.left);
        int right = 1 + getTreeLenght(root.right);
        return Math.max(left, right);
    }

    /**
     * 1、如何计算差值
     *
     * @param root
     * @return
     */

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(getHight(root.left) - getHight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getHight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHight(node.left), getHight(node.right)) + 1;
    }
    public boolean isBalanced6(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if(left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if(right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
