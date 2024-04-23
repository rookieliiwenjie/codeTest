package LeetCode.oneHuFive;

import LeetCode.Tree.TreeNode;

import java.util.*;

public class RightSideView {
    public static void main(String[] args) {
        RightSideView rightSideView = new RightSideView();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left1 = new TreeNode(5);
        TreeNode right1 = new TreeNode(4);
        root.left = left;
        root.right = right;
        left.right = left1;
        right.right = right1;
        List<Integer> list = rightSideView.rightSideView3(root);
        System.out.println(list.toString());
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> right = new LinkedList<>();
        right.offer(root);
        while (!right.isEmpty()) {
            int size = right.size();
            result.add(right.peek().val);
            while (size > 0) {
                TreeNode poll = right.poll();
                if (poll.right != null) {
                    right.offer(poll.right);
                }
                if (poll.left != null) {
                    right.offer(poll.left);
                }
                size--;
            }
        }
        return result;

    }

    /**
     * 二叉树的深度优先搜索
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        nodeQueue.add(root);
        depthQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();
            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);
                // 由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
                rightmostValueAtDepth.put(depth, node.val);
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }
        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView3(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;
        Deque<TreeNode> nodeStack = new LinkedList<TreeNode>();
        Deque<Integer> depthStack = new LinkedList<Integer>();
        nodeStack.push(root);
        depthStack.push(0);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);
                // 如果不存在对应深度的节点我们才插入
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }
}
