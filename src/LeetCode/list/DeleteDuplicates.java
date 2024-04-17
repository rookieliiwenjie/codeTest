package LeetCode.list;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(-102, head);
        ListNode current = newHead;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int x = current.next.val;
                while (current.next != null && current.next.val == x) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return newHead.next;
    }

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
        ListNode listNode = deleteDuplicates.deleteDuplicates2(head);
        System.out.println(listNode);
    }

    public ListNode deleteDuplicates2(ListNode head) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> newNode = new HashSet<>();
        while (head != null) {
            if (set.contains(head.val)) {
                newNode.remove(head.val);
            } else {
                set.add(head.val);
                newNode.add(head.val);
            }
            head = head.next;
        }
        ListNode newHead = new ListNode(-102);
        ListNode current = newHead;
        HashSet<Integer> sorted = newNode.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        for (Integer integer : sorted) {
            current.next = new ListNode(integer);
            current = current.next;
        }
        return newHead.next;

    }
}
