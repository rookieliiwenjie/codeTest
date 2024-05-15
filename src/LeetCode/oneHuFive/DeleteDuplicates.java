package LeetCode.oneHuFive;

import LeetCode.list.ListNode;

public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        head.next = head2;
        ListNode head3 = new ListNode(3);
        head2.next = head3;
        ListNode head4 = new ListNode(3);
        head3.next = head4;
        ListNode head5 = new ListNode(4);
        head4.next = head5;
        ListNode head6 = new ListNode(4);
        head5.next = head6;
        ListNode head7 = new ListNode(5);
        head6.next = head7;
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode listNode = deleteDuplicates.deleteDuplicates3(head);
        System.out.println(listNode);
    }

    /**
     * 删除重复项都变成单个
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curron = head;
        ListNode next = head.next;
        while (curron != null && next != null) {
            if (curron.val == next.val) {
                next = next.next;
            } else {
                curron.next = next;
                curron = curron.next;
                next = next.next;
            }
        }
        if (next != null) {
            curron.next = null;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-101);
        pre.next = head;
        ListNode curron = pre;
        ListNode begin = pre.next;
        ListNode end = begin;
        boolean flag = false;
        while (begin != null && begin.next != null) {
            ListNode node = begin.next;
            if (begin.val == node.val) {
                end = end.next;
            } else {
                if (flag) {
                    curron.next = end;
                }
                begin = curron.next;
                end = begin;
                curron = curron.next;
            }
        }
        if (end != null) {
            curron.next = null;
        }
        return head;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-102);
        pre.next = head;
        ListNode curron = pre;
        ListNode begin = pre.next;
        while (begin != null && begin.next != null) {
            ListNode end = begin.next;
            boolean flag = false;
            while (end != null && end.val == begin.val) {
                end = end.next;
                flag = true;
            }
            if (flag) {
                curron.next = end;
                begin = curron.next;
                continue;
            }
            curron = curron.next;
            begin = curron.next;
        }
        return pre.next;
    }
}
