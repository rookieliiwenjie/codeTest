package LeetCode.Tree;

import java.util.*;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/30 3:49 下午
 * @Description:
 */
public class DelNodes {

    /**
     * 如何判断不相交（独立没有相交，如何判断没有相交） //如果上一个节点符合，当前节点不是那么就是一个新树
     * 2、最开始的那个咋办，
     *
     * @param root
     * @param to_delete
     * @return
     */
    public static List<TreeNode> delNodes2(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();

        for (int num : to_delete) {
            set.add(num);
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        pre(root, treeNodes, true,set);
        return treeNodes;
    }

    public static void pre(TreeNode node, List<TreeNode> treeNodes, boolean isRoot,Set<Integer> set) {
        if (node == null) {
            return;
        }
        // 2、最开始的那个咋办，通过这个

        //确认是否是根节点，如果为true
       boolean flag = set.contains(node.val);
        pre(node.left, treeNodes, flag,set);
        pre(node.right, treeNodes, flag,set);
        if (flag) {
            node = null;
        } else {
            if (isRoot) {
                treeNodes.add(node);
            }
        }
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
         Set<Integer> set = new HashSet<>();

        for (int num : to_delete) {
            set.add(num);
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        dfs(treeNodes, root, set.contains(root.val),set);
        return treeNodes;
    }

    public static TreeNode dfs(List<TreeNode> treeNodes, TreeNode node, boolean isRoot,Set<Integer> set) {
        if (node == null) {
            return null;
        }
        boolean flag = set.contains(node.val);
        node.left = dfs(treeNodes, node.left, flag,set);
        node.right = dfs(treeNodes, node.right, flag,set);
        //如果当前没有匹配到，
        if(flag){
            return null;
        }else {
            //如果上一个节点符合，当前节点不是那么就是一个新树
            if(isRoot){
                treeNodes.add(node);
            }
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootleft = new TreeNode(2);
        TreeNode rootright = new TreeNode(3);
        root.left = rootleft;
        root.right = rootright;
        TreeNode rootleftleft = new TreeNode(4);
        TreeNode rootleftright = new TreeNode(5);
        rootleft.left = rootleftleft;
        rootleft.right = rootleftright;
        TreeNode rootrightleft = new TreeNode(6);
        TreeNode rootrightright = new TreeNode(7);
        rootright.left = rootrightleft;
        rootright.right = rootrightright;
        int arr[] = {3, 5};

//        TreeNode root = new TreeNode(1);
//        TreeNode rootleft = new TreeNode(2);
//        TreeNode rootright = new TreeNode(4);
//        TreeNode rootrightright = new TreeNode(3);
//        root.left = rootleft;
//        root.right = rootright;
//        rootright.right = rootrightright;
//        int arr[] = {3};
        delNodes2(root, arr);

    }
}
