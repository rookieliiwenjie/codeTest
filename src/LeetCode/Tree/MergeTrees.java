package LeetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTrees {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root1Left = new TreeNode(3);
        TreeNode root1Right = new TreeNode(2);
        root1.left = root1Left;
        root1.right = root1Right;
        TreeNode root1LeftLeft = new TreeNode(5);
        root1Left.left = root1LeftLeft;

        TreeNode root2 = new TreeNode(2);
        TreeNode root2left = new TreeNode(1);
        TreeNode root2right = new TreeNode(3);
        root2.left = root2left;
        root2.right = root2right;
        TreeNode root2LeftRight = new TreeNode(4);
        root2left.right = root2LeftRight;
        TreeNode root2Rrightight = new TreeNode(7);
        root2right.right = root2Rrightight;

        MergeTrees mergeTrees = new MergeTrees();
        TreeNode treeNode = mergeTrees.mergeTrees(root1, root2);
        System.out.println(treeNode);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;

    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue.offer(merged);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }
        return merged;
    }


}
