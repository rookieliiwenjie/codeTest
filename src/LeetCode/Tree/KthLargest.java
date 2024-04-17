package LeetCode.Tree;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/11 4:41 下午
 * @Description:
 */
public class KthLargest {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//        TreeNode rootLeft = new TreeNode(1);
//        TreeNode rootRight = new TreeNode(6);
//        root.left = rootLeft;
//        TreeNode rootRightLeft = new TreeNode(7);
//        TreeNode rootRightRight = new TreeNode(5);
//        rootRight.right = rootRightLeft;
//        rootRight.left = rootRightRight;
//        root.right = rootRight;
        TreeNode root = new TreeNode(1);
        //TreeNode rootLeft = new TreeNode();
        //TreeNode rootRight = new TreeNode();
      //  root.right = rootRight;
//        TreeNode rootLeftRight = new TreeNode(2);
//        rootLeft.right = rootLeftRight;
      //  root.left = rootLeft;
        System.out.println("rootRightRight = " + kthLargest2(root, 1));
    }

    static int num = 0;
    static int res = 0;
    static int k;

    public static int kthLargest(TreeNode root, int k) {
        getKth(root, k);
        return res;
    }
    public static int kthLargest2(TreeNode root, int k) {
        dfs(root);
        return res;
    }
   static void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
    public static void getKth(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        getKth(root.right, k);
        num++;
        if (num == k) {
            res = root.val;
        }
        getKth(root.left, k);
    }
}
