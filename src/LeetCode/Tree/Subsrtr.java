package LeetCode.Tree;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/22 10:26 上午
 * @Description:
 */
public class Subsrtr {
    /**
     * 1。大概率是递归查出来每一个路径上的和，但是如果前一个后一个相加有等于了咋办(做法就是全部删除)，这里有待商榷
     *
     * @param root
     * @param limit
     * @return
     */
    public static TreeNode subTest(TreeNode root, int limit) {
        boolean flag = cheack(root, limit, 0);
        return flag ? root : null;
    }

    public static boolean cheack(TreeNode node, int limit, int sum) {
        if (node == null) {
            return false;
        }
        if (node.right == null && node.left == null) {
            return node.val + sum >= limit;
        }
        boolean checkLeft = cheack(node.left, limit, sum+node.val);
        boolean checkRight = cheack(node.right, limit, sum+node.val);
        if (!checkLeft) {
            node.left = null;
        }
        if (!checkRight) {
            node.right = null;
        }
        return checkLeft || checkRight;

    }

    public static void main(String[] args) {

    }
}
