package com.company.LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-10-12 15:21
 */
public class LowestCommonAncestor {
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
     * 示例 1:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * 示例 2:
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //定义p的路径
        List<TreeNode> pPath = getPath(root, p);
        //定义q的路径
        List<TreeNode> qPath = getPath(root, q);
        //公共节点
        TreeNode returnTreeNode = null;
        //获取p和q的路径
        for (int i = 0; i < qPath.size() && i < pPath.size(); i++) {
            if (qPath.get(i) == pPath.get(i)) {
                returnTreeNode = pPath.get(i);
            } else {
                break;
            }
        }
        return returnTreeNode;
    }

    /**
     * 如果 当前大于qp 那么选择左边比较小的
     * 如果 同时大于qp 那么选择右边
     * 如果同时不满足 那么返回
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode treeNode = root;
        while (true) {
            if (p.val > treeNode.val && q.val > treeNode.val) {
                treeNode = treeNode.right;
            } else if (p.val < treeNode.val && q.val < treeNode.val) {
                treeNode = treeNode.left;
            } else {
                break;
            }
        }
        return treeNode;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (node.val > target.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        path.add(node);
        return path;
    }

    private List<TreeNode> getPath2(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<TreeNode>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }
}
