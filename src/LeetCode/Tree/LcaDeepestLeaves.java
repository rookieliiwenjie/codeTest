package LeetCode.Tree;

public class LcaDeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int sum = 0;
        dfs(root, sum);
        return root;
    }

    public int dfs(TreeNode treeNode, int sum) {
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.left != null) {

        }
        if (treeNode.right != null) {

        }
        return Math.max(sum, 1);
    }
}
