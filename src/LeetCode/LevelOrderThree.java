package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在此填写类的用途、注意事项等
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 */
public class LevelOrderThree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);
        root.left = rootLeft;
        root.right = rootRight;
        TreeNode rootRightLeft = new TreeNode(15);
        TreeNode rootRightRight = new TreeNode(7);
        rootRight.right = rootRightRight;
        rootRight.left = rootRightLeft;
        List<List<Integer>> list = levelOrder(root);
        System.out.println("list = " + list);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int nums = 2;
        while (!queue.isEmpty()) {
            LinkedList<Integer> newList = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                if (nums % 2 == 0) {
                    newList.addLast(poll.val);

                }else {
                    newList.addFirst(poll.val);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            nums++;
            list.add(newList);
        }
        return list;
    }
}
