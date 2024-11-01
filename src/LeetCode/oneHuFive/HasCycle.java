package LeetCode.oneHuFive;

import LeetCode.list.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    /**
     * 是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * hash 玩法
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> listNodes = new HashSet<>();
        while (head != null) {
            if (listNodes.contains(head)) {
                return true;
            }
            listNodes.add(head);
            head = head.next;
        }
        return false;
    }


}
