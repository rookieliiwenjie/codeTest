package LeetCode.Tree;

public class IsSameTree {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        p.left = p1;
        TreeNode q = new TreeNode(1);
        TreeNode q1 = new TreeNode(2);
        q.right = q1;
        IsSameTree isSameTree = new IsSameTree();
        System.out.println(isSameTree.isSameTree(p, q));
    }

    //    p =
//            [1,2]
//    q =
//            [1,null,2]
//    输出
//true
//    预期结果
//false
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null) || (q == null)) {
            return false;
        }
        if (p.right == null && q.right != null) {
            return false;
        }
        if (p.left == null && q.left != null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(q.right, p.right);
    }
}
