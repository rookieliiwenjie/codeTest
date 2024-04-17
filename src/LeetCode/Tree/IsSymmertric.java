package LeetCode.Tree;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/15 6:54 下午
 * @Description:
 */
public class IsSymmertric {
    public static boolean isSymmetric(TreeNode root){
       return check(root,root);
    }

    public static boolean check(TreeNode p ,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null ||q==null){
            return false;
        }
        return( p.val == q.val) && check(p.left,q.right) && check(p.right,q.left);
    }
}
