package LeetCode.Tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/31 8:15 下午
 * @Description:
 */
public class FindTarget {


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
        System.out.println("rootRightRight = " +         findTarget(root,20));
    }
    public static boolean findTree(TreeNode root, Set<Integer> set,int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTree(root.right, set, k) || findTree(root.left, set, k);
    }
    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> integerSet = new HashSet<>();
        if (root == null) {
            return false;
        }
        if (integerSet.contains(k - root.val)) {
            return true;
        }
        integerSet.add(root.val);
        return findTarget(root.right, k) || findTarget(root.left, k);
    }

//    public static boolean findTarget2(TreeNode root, int k) {
//
//    }
}
