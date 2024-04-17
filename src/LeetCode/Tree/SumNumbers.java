package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/23 6:18 下午
 * @Description:
 */
public class SumNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode rootleft = new TreeNode(9);
        TreeNode rootright = new TreeNode(0);

        TreeNode rootrightleft = new TreeNode(1);
        TreeNode rootrightright = new TreeNode(5);
        rootleft.right = rootrightright;
        rootleft.left = rootrightleft;
        root.left = rootleft;
        root.right = rootright;
        System.out.println("rootrightright = " + sumNumbers(root));

    }

    static List<List<Integer>> newArr = new ArrayList<>();

    /**
     * 如果左右节点处理
     *
     * @param root
     * @return
     */
    public static int sumNumbers(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        left.add(root.val);
        List<Integer> right = new ArrayList<>();
        right.add(root.val);
        getNumber(root.left, left);
        getNumber(root.right, right);
        int sum = 0;
        for (List<Integer> arr : newArr) {
            StringBuilder s = new StringBuilder();
            for (Integer num : arr) {
                s.append(num);
            }
            sum += Integer.parseInt(s.toString());
        }
        return sum;
    }

    public static void getNumber(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        arr.add(node.val);
        List<Integer> left = new ArrayList<>(arr);
        List<Integer> right = new ArrayList<>(arr);
        if (node.left == null && node.right == null) {
            newArr.add(arr);
        }
        getNumber(node.left, left);
        getNumber(node.right, right);
    }


    public int sumNumbers2(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
