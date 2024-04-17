package LeetCode.oneHuFive;

import LeetCode.Tree.TreeNode;

import java.util.*;

public class SumNumbers {
    List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        SumNumbers sumNumbers = new SumNumbers();
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(0);
        root.left = left;
        root.right = right;
        TreeNode left1 = new TreeNode(5);
        TreeNode right1 = new TreeNode(1);
        left.left = left1;
        left.right = right1;
        System.out.println(sumNumbers.sumNumbers3(root));
    }

    public int sumNumbers(TreeNode root) {
        int sum = 0;

        if (root == null) {
            return sum;
        }
        getNumList(root, new ArrayList<>());
        for (int i = 0; i < list.size(); i++) {
            List<Integer> list1 = list.get(i);
            StringBuilder num = new StringBuilder();
            for (Integer integer : list1) {
                num.append(integer);
            }
            sum += Integer.parseInt(num.toString());
        }
        return sum;
    }

    public void getNumList(TreeNode node, List<Integer> preList) {
        if (node == null) {
            list.add(preList);
            return;
        }
        if ((node.left == null && node.right == null)) {
            preList.add(node.val);
            list.add(preList);
            return;
        }
        preList.add(node.val);
        if (node.left != null) {
            List<Integer> leftList = new ArrayList<>(preList);
            getNumList(node.left, leftList);
        }
        if (node.right != null) {
            List<Integer> rightList = new ArrayList<>(preList);
            getNumList(node.right, rightList);

        }
    }


    public int sumNumbers2(TreeNode root) {
        int sum = 0;

        if (root == null) {
            return sum;
        }
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int prevSum) {
        if (node == null) {
            return 0;
        }
        int sum = prevSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        } else {
            return dfs(node.left, sum) + dfs(node.right, sum);
        }
    }

    /**
     * 广度搜索
     *
     * @param root
     * @return
     */
    public int sumNumbers3(TreeNode root) {
        int sum = 0;

        if (root == null) {
            return sum;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> num = new LinkedList<Integer>();
        queue.offer(root);
        num.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            Integer pollNum = num.poll();
            if (poll.left == null && poll.right == null) {
                sum += pollNum;
            }
            if (poll.left != null) {
                queue.offer(poll.left);
                num.offer(pollNum * 10 + poll.left.val);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                num.offer(pollNum * 10 + poll.right.val);
            }
        }
        return sum;
    }


}
