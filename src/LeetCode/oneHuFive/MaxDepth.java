package LeetCode.oneHuFive;

import LeetCode.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rootleft = new TreeNode(9);
        TreeNode rootright = new TreeNode(20);

        TreeNode rootrightleft = new TreeNode(15);
        TreeNode rootrightright = new TreeNode(7);
        rootright.right = rootrightright;
        rootright.left = rootrightleft;
        root.left = rootleft;
        root.right = rootright;
        // levelOrder(root);
        System.out.println("rootrightright = " + maxDepth3(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMax(root.left, 1), getMax(root.right, 1));
    }

    public static int getMax(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        }
        int left = getMax(node.left, depth + 1);
        int right = getMax(node.right, depth + 1);
        return Math.max(left, right);
    }

    /**
     * 深度遍历
     *
     * @param root
     * @return
     */

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth2(root.left) + 1;
        int right = maxDepth2(root.right) + 1;
        return Math.max(left, right);
    }

    /**
     * 广度遍历
     *
     * @param root
     * @return
     */
    public static int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                //清掉每一层的数据
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            max++;
        }
        return max;

    }


}
