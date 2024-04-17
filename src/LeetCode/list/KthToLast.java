package LeetCode.list;

import java.util.ArrayList;
import java.util.List;

public class KthToLast {

    public int kthToLast(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.get(list.size() - k);
    }

    public int kthToLast2(ListNode head, int k) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur= temp;
        }
        for (int i = 0; i < k-1; i++) {
            pre = pre.next;
        }
        return pre.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        int i = new KthToLast().kthToLast2(head, 2);
        System.out.println(i);
    }
}
