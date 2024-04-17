package LeetCode;

import LeetCode.Tree.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/5 1:58 下午
 * @Description:
 */
public class BuildTree {
    private Map<Integer, Integer> indexMap;

    //前根左右 //中左根右
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {

        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        // 在中序遍历中定位根节点
        //获取中的根节点
        int inorderRoot = indexMap.get(preorder[preorder_left]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_left]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorderRoot - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorderRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorderRoot + 1, inorder_right);
        return root;
    }
    public TreeNode buildTree3(int preleft, int preright, int[] preorder, int[] inorder, int inleft, int inright) {
        if (preleft > preright) {
            return null;
        }
        //根节点 下标
        int inRootIndex = indexMap.get(preorder[preleft]);
        //根据中旬根节点 获取左子数长度 根据这个可以获取到前徐的左和右树
        int leftLegnht = inRootIndex - inleft;
        TreeNode root = new TreeNode(preorder[preleft]);
        root.left = buildTree3(preleft + 1, preleft+leftLegnht, preorder, inorder, inleft, inRootIndex - 1);
        root.right = buildTree3(preleft + leftLegnht + 1, preright, preorder, inorder, inRootIndex +1, inright);
        return root;
    }
    ///前根左右 //中左根右
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
//        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        return buildTree3(0, n-1, preorder, inorder, 0, n - 1);
    }




    //前根左右 中 左根右
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
