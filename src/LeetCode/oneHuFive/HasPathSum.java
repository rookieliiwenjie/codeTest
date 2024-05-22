package LeetCode.oneHuFive;

import LeetCode.Tree.TreeNode;

public class HasPathSum {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode left = new TreeNode(2);
//        root.left = left;
//        TreeNode right = new TreeNode(3);
//        root.right = right;


        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        root.left = left;
        TreeNode right = new TreeNode(8);
        root.right = right;
        TreeNode left1 = new TreeNode(11);
        left.left = left1;
        TreeNode left2 = new TreeNode(7);
        TreeNode right2 = new TreeNode(2);
        left1.left = left2;
        left1.right = right2;
        TreeNode right1 = new TreeNode(4);
        right.left = right1;
        TreeNode left3 = new TreeNode(13);
        TreeNode right3 = new TreeNode(1);
        right1.left = left3;
        right1.right = right3;
        HasPathSum hasPathSum = new HasPathSum();
        System.out.println(hasPathSum.hasPathSum(root, 22));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return getSum(root, targetSum, 0);
    }

    /**
     * 递归
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }


    public boolean getSum(TreeNode node, int targetSum, int sum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return targetSum == sum + node.val;
        }
        return getSum(node.left, targetSum, node.val + sum) || getSum(node.right, targetSum, node.val + sum);
    }
}
