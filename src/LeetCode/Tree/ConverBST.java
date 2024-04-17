package LeetCode.Tree;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/9 8:31 下午
 * @Description:
 */
public class ConverBST {
    public static int sum = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode rootLeft = new TreeNode(1);
        TreeNode rootRight = new TreeNode(6);
        root.left = rootLeft;
        TreeNode rootRightLeft = new TreeNode(7);
        TreeNode rootRightRight = new TreeNode(5);
        rootRight.right = rootRightLeft;
        rootRight.left = rootRightRight;
        root.right = rootRight;
        System.out.println("rootRightRight = " + convertBST(root));

    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        sum+=root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

//    public static TreeNode convertBST2(TreeNode root){
//        TreeNode newRoot = new TreeNode();
//        Queue<TreeNode> treeNodes = new
//        while ()
//
//            return newRoot;
//    }
    //大于或者等于改节点所有值的和
    public static void preOrder(TreeNode node) {

    }
}
