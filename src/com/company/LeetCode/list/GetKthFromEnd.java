package com.company.LeetCode.list;

import java.util.List;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-09-26 15:25
 */
public class GetKthFromEnd {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode() {
        }
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * <p>
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     * <p>
     * 返回链表 4->5.
     * <p>
     * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
     */
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode head2 = new ListNode(2);
//        head.next = head2;
//        ListNode head3 = new ListNode(3);
//        head2.next = head3;
//        ListNode head4 = new ListNode(4);
//        head3.next = head4;
//        ListNode head5 = new ListNode(5);
//        head4.next = head5;
//        ListNode kthFromEnd = getKthFromEnd(head, 2);
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(3);
        head.next = head2;
        ListNode head3 = new ListNode(5);
        head2.next = head3;
        ListNode head4 = new ListNode(7);
        head3.next = head4;
        ListNode head5 = new ListNode(9);
        head4.next = head5;




        ListNode head22 = new ListNode(2);
        ListNode head21 = new ListNode(4);
        head22.next = head21;
        ListNode head33 = new ListNode(6);
        head21.next = head33;
        ListNode head44 = new ListNode(8);
        head33.next = head44;
        //mergeTwoLists(head,head22);
        ListNode node = mergeTwoLists2(head, head22);
        System.out.println("node = " + node);


    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head =  new ListNode(-1);
        ListNode crronListNode = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                crronListNode.next = l1;
                l1 = l1.next;
            } else {
                crronListNode.next = l2;
                l2 = l2.next;
            }
            crronListNode = crronListNode.next;
        }
        if (l1 != null) {
            crronListNode.next = l1;
        } else {
            crronListNode.next = l2;
        }
        return head.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }


    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode newHead = head;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        for (int i = 1; i <= size - k; i++) {
            newHead =newHead.next;
        }
        return newHead;
    }
}
