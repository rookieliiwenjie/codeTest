package LeetCode.everyDay;

import LeetCode.Tree.TreeNode;
import LeetCode.list.ListNode;

import java.util.List;

public class IsSubPath {
    /**
     * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
     * <p>
     * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一
     * 对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
     * <p>
     * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
     */

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (head.val != root.val) {
            return false;
        }
        return dfs(head.next, root.right) || dfs(head.next, root.left);
    }

    public static void main(String[] args) {
        IsSubPath isSubPath = new IsSubPath();

//        ListNode listNode = new ListNode();
//        listNode.setVal(1);
//        ListNode listNode2 = new ListNode();
//        listNode2.setVal(2);
//        ListNode listNode3 = new ListNode();
//        listNode3.setVal(3);
//        ListNode listNode4 = new ListNode();
//        listNode4.setVal(4);
//        ListNode listNode5 = new ListNode();
//        listNode5.setVal(5);
//        ListNode listNode6 = new ListNode();
//        listNode6.setVal(6);
//        listNode5.next = listNode6;
//        listNode.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        TreeNode treeNode = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode6 = new TreeNode(6);
//        treeNode5.left = treeNode6;
//        treeNode.left = treeNode2;
//        treeNode2.left = treeNode3;
//        treeNode3.left = treeNode4;
//        treeNode4.left = treeNode5;
//         构建二叉树
        TreeNode root = new TreeNode(4);              // 根节点
        root.left = new TreeNode(4);                  // 左子节点
        root.right = new TreeNode(4);                 // 右子节点
        root.left.left = new TreeNode(1);             // 左子节点的左子节点
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(2);

        ListNode listNode = new ListNode();
        listNode.setVal(4);
        ListNode listNode2 = new ListNode();
        listNode2.setVal(2);
        listNode.next = listNode2;
        System.out.println(isSubPath.isSubPath(listNode, root));
    }
}
