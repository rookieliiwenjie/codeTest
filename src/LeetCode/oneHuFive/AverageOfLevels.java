package LeetCode.oneHuFive;

import LeetCode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    public static void main(String[] args) {
        AverageOfLevels averageOfLevels = new AverageOfLevels();
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        List<Double> doubles = averageOfLevels.averageOfLevels(treeNode);
        System.out.println(doubles);
    }

    public List<Double> avergeOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Double> doubles = new ArrayList<>();
        while (!queue.isEmpty()) {
            int num = queue.size();
            int size = num;
            double sum = 0;
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);

                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                sum += poll.val;
                size--;

            }
            doubles.add(sum / num);

        }
        return doubles;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> counts = new ArrayList<Integer>();
        List<Double> sums = new ArrayList<Double>();
        getNode(root, 0, counts, sums);
        List<Double> averages = new ArrayList<Double>();
        int size = sums.size();
        for (int i = 0; i < size; i++) {
            averages.add(sums.get(i) / counts.get(i));
        }
        return averages;
    }

    public void getNode(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
        if (root == null) {
            return;
        }
        //这里就是关键，如果level小于sums的size，说明这个level已经有值了，直接加上就行了
        //level = 0 sum = 1
        //level = 1 sum = 2
        //level = 2 sum = 3 max = 4
        if (level < sums.size()) {
            sums.set(level, sums.get(level) + root.val);
            counts.set(level, counts.get(level) + 1);
        } else if(level>=sums.size()) {
            sums.add(1.0 * root.val);
            counts.add(1);
        }
        getNode(root.right, level + 1, counts, sums);
        getNode(root.left, level + 1, counts, sums);
    }
}
