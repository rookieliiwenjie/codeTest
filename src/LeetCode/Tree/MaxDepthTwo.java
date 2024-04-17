package LeetCode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/15 8:19 下午
 * @Description:
 */
public class MaxDepthTwo {
    static int max = 0;

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

    //迭代
    public static int maxDepth2(TreeNode root) {
        int  max = 0;
        if (root == null) {
            return max;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()){
            int lenght = treeNodes.size();
            for (int i = 0; i < lenght; i++) {
                TreeNode poll = treeNodes.poll();
                if(poll.left!=null){
                    treeNodes.offer(poll.left);
                }
                if(poll.right!=null){
                    treeNodes.offer(poll.right);
                }
                max +=max;
            }
        }
        return max;
    }
}
