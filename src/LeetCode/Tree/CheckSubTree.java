package LeetCode.Tree;

public class CheckSubTree {
    TreeNode rNode = null;

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        rNode = t2;
        return checkNode(t1, rNode);
    }

    public boolean checkNode(TreeNode t1, TreeNode t2) {
        if ((t1 == null && t2 == null) || (t1 != null && t2 == null)) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        // 判断其他节点是否正确
        if (t1.val == t2.val) {
            return checkNode(t1.left, t2.left) && checkNode(t1.right, t2.right);
        }
        return checkNode(t1.left, rNode) || checkNode(t1.right, rNode);
    }


    public static void main(String[] args) {
        CheckSubTree checkSubTree = new CheckSubTree();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(2);
        t1.left.right.left = new TreeNode(4);
        t1.left.right.right = new TreeNode(5);


        t1.right = new TreeNode(2);
        t1.right.left = new TreeNode(4);
        t1.right.right = new TreeNode(6);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(4);
        t2.right = new TreeNode(5);
        System.out.println(checkSubTree.checkSubTree(t1, t2));


//        TreeNode t3 = new TreeNode(2);
//        t3.left = new TreeNode(4);
//        System.out.println(checkSubTree.checkSubTree(t1, t3));

    }


}
