package LeetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/16 3:18 下午
 * @Description:从底到顶的
 */
public class LevelOrderBottom {
    public static List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> data = new ArrayList<>();
        if(root==null){
            return data;
        }
        buildList(root,0,data);
        return data;

    }

    /**
     * 1.我不知道如何进行插入操作
     * 2、 不知道如何放到一个list中
     * @param root
     * @param index
     * @param arr
     */
    public static  void buildList(TreeNode root,Integer index,List<List<Integer>> arr){
        if (root == null) {
            return;
        }
        if (index == arr.size()) {
            arr.add(0, new ArrayList<>());
        }
        List<Integer> list = new ArrayList<>();
        arr.get(index).add(root.val);
        buildList(root.left,index+1,arr);
        buildList(root.right,index+1,arr);
    }
    public void dfs(TreeNode node, int depth, List<List<Integer>> res) {
        if(node==null){
            return;
        }
        //这里是我的第1和第2个疑惑。
        if(depth==res.size()){
            res.add(0,new ArrayList<>());
        }
        //这里的get是0就是我的第一个疑惑
        res.get(res.size()-depth-1).add(node.val);
        dfs(node.left,depth+1,res);
        dfs(node.right,depth+1,res);
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            levelOrder.add(0, level);
        }
        return levelOrder;
    }


    public List<List<Integer>> levelOrderBottom3(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(root, 0, res);
        return res;
    }


}
