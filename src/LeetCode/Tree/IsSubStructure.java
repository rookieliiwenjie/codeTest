package LeetCode.Tree;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/11 6:59 下午
 * @Description:
 */
public class IsSubStructure {
    public static void main(String[] args) {

    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (isSubStructure(A.left, B) || isSubStructure(A.right, B) || isTrue(A, B));
    }

    public static boolean isTrue(TreeNode node, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (node == null) {
            return false;
        }
        return node.val == B.val && isTrue(node.left, B.left) && isTrue(node.right, B.right);
    }


//    public static boolean ist(int i) {
//        if (i < 0) {
//            return false;
//        }
//        if (i == 1) {
//            return true;
//        }
//        i = i - 1;
//        return ist(i);
//    }

//    public static boolean isSubStrucTure(TreeNode A, TreeNode B) {
//
//        return (A != null && B != null) && (isTrue(A, B) || isSubStrucTure(A.left, B) || isSubStrucTure(A.right, B));
//    }
//
//
//    public static boolean isTrue(TreeNode A, TreeNode B) {
//        if (B == null) {
//            return true;
//        }
//        if (A == null || A.val != B.val) {
//            return false;
//        }
//        return isTrue(A.left, B.left) && isTrue(B.right, B.right);
//    }

}
