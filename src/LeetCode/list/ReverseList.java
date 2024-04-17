package LeetCode.list;

import java.util.List;

public class ReverseList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.setVal(1);
        ListNode listNode2 = new ListNode();
        listNode2.setVal(2);
        ListNode listNode3 = new ListNode();
        listNode3.setVal(3);
        ListNode listNode4 = new ListNode();
        listNode4.setVal(4);
        ListNode listNode5 = new ListNode();
        listNode5.setVal(5);
        ListNode listNode6 = new ListNode();
        listNode6.setVal(6);
        listNode5.next = listNode6;
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ReverseList reverseList = new ReverseList();
        reverseList.reverseList(listNode);

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        return Digui(head, null);
    }

    public ListNode digui(ListNode node, ListNode pre) {
        if (node == null) {
            return pre;
        }
        ListNode next = node.next;
        node.next = pre;
        return digui(next, node);
    }


    public ListNode Digui(ListNode node, ListNode pre) {
        if (node == null) {
            return node;
        }
        ListNode next = node.next;
        next.next = pre;
        return Digui(node, next);
    }


    public ListNode recoverList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public ListNode diguiTest(ListNode cur, ListNode pre) {

        if (pre == null) {
            return pre;
        }
        ListNode next = diguiTest(cur, cur.next);

        return next;

    }


}
