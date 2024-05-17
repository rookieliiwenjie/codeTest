package LeetCode.oneHuFive;

import LeetCode.Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
//        TreeNode root = new TreeNode(1);
//        TreeNode left = new TreeNode(2);
//        TreeNode right = new TreeNode(2);
//        root.left = left;
//        root.right = right;
//        TreeNode left1 = new TreeNode(3);
//        TreeNode right1 = new TreeNode(4);
//        left.left = left1;
//        left.right = right1;
//        TreeNode rightLeft = new TreeNode(4);
//        TreeNode rightRight = new TreeNode(3);
//        right.left = rightLeft;
//        right.right = rightRight;
//        TreeNode root = new TreeNode(1);
//        TreeNode left = new TreeNode(2);
////        TreeNode right = new TreeNode(2);
//        root.left = left;
//        root.right = right;
//        left.right = new TreeNode(3);
//        right.right = new TreeNode(3);

        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(5);
        left.left = left1;
        left.right = right1;
        TreeNode rightRight = new TreeNode(4);
        right.right = rightRight;
        boolean symmetric = isSymmetric.isSymmetric2(root);
        System.out.println(symmetric);

    }

    public boolean isSymmetric(TreeNode root) {

        java.util.Deque<TreeNode> queueLeft = new LinkedList<>();
        queueLeft.add(root.left);
        java.util.Deque<TreeNode> queueRight = new LinkedList<>();
        queueRight.add(root.right);
        while (!queueLeft.isEmpty() && !queueRight.isEmpty()) {
            int size = queueLeft.size();
            int rightSize = queueRight.size();
            if (size != rightSize) {
                return false;
            }
            while (size > 0) {
                TreeNode right = queueRight.pollLast();
                TreeNode left = queueLeft.poll();
                if (left == null || right == null) {
                    continue;
                }
                if (left.val != right.val) {
                    return false;
                }
                if (left.left != null) {
                    queueLeft.offer(left.left);
                }
                if (left.right != null) {
                    queueLeft.offer(left.right);
                }
                if (left.val != right.val) {
                    return false;
                }
                if (right.right != null) {
                    queueRight.offer(right.right);
                }
                if (right.left != null) {
                    queueRight.offer(right.left);
                }
                size--;
            }
        }
        return queueLeft.isEmpty() && queueRight.isEmpty();

    }

    public boolean isSymmetric2(TreeNode root) {

        Deque<TreeNode> queueLeft = new LinkedList<>();
        if (root.left != null) {
            queueLeft.add(root.left);
        }
        Deque<TreeNode> queueRight = new LinkedList<>();
        if (root.right != null) {
            queueRight.add(root.right);
        }
        while (!queueLeft.isEmpty() && !queueRight.isEmpty()) {
            TreeNode left = queueLeft.poll();
            TreeNode right = queueRight.pollLast();
            if (left == null || right == null) {
                continue;
            }
            if (left.val != right.val) {
                return false;
            }
            if (left.left == null && right.right != null || left.left != null && right.right == null
                    || left.right == null && right.left != null
                    || left.right != null && right.left == null) {
                return false;
            }
            if (left.left != null) {
                queueLeft.offer(left.left);
            }
            if (left.right != null) {
                queueLeft.add(left.right);
            }
            if (right.right != null) {
                queueRight.offerFirst(right.right);

            }
            if (right.left != null) {
                queueRight.offerFirst(right.left);
            }
        }
        return queueLeft.isEmpty() && queueRight.isEmpty();
    }

    /**
     * 官方版本
     *
     * @param root
     * @return
     */
    public boolean isSymmetric3(TreeNode root) {
        return true;

    }

    /**
     * 递归版本吧
     *
     * @param root
     * @return
     */
    /**
     * 1
     * 2         2
     * 3  4      4   3  /// 3 3 4 4
     * //  4 4 5 5 6 6
     * //5 5  6 6 7 7 8 8
     * 5,6,7,8   8,7 6,5
     *
     * @param root
     * @return
     */
    public boolean isSymmetric4(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root.right);
        q.offer(root.left);
        while (!q.isEmpty()) {
            TreeNode u = q.poll();
            TreeNode v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }
            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

    public boolean check2(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

    public boolean isSymmetric5(TreeNode root) {

        return check(root, root);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}
