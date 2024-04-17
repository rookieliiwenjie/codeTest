package LeetCode.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PathSum {

    public static void main(String[] args) {

    }

    List<List<Integer>> array = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return array;
        }
        getSum(root, target);
        return array;
    }

    /**
     * 如果确认到了最后的节点 --- 通過target==0
     *
     * @param node
     * @return
     */
    public void getSum(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        target -= node.val;
        deque.offerFirst(node.val);
        if (node.left == null && node.right == null && target == 0) {

        }
        getSum(node.left, target);
        getSum(node.right, target);
        deque.pollLast();
    }


}
