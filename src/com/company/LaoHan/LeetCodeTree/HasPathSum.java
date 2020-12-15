package com.company.LaoHan.LeetCodeTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lwj32 on 2020/7/7.
 */
public class HasPathSum {
    public static void main(String[] args) {
        Queue<Integer> queVal = new LinkedList<Integer>();
        queVal.add(1);
        queVal.add(2);
        System.out.println("queVal.poll() = " + queVal.poll());
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> val = new LinkedList<>();
        queue.offer(root);
        val.offer(root.val);
        while (!queue.isEmpty()){
            int tem = val.poll();
            TreeNode now = queue.poll();
            if(now.left==null&&now.right==null){
                if(tem==sum){
                    return true;
                }
                continue;
            }
            if(now.left!=null){
                queue.offer(now.left);
                val.offer(tem+now.left.val);
            }
            if(now.right!=null){
                queue.offer(now.right);
                val.offer(tem+now.right.val);
            }

        }
        return false;
    }
}
