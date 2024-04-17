package LeetCode.list;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodes {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        new RemoveDuplicateNodes().reateNmoveDuplicodes2(listNode);
        System.out.println(listNode);
    }

    /**
     * n2
     * 和
     * 1
     *
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            ListNode curron = temp;
            while (curron.next != null && curron.val == curron.next.val) {
                curron.next = curron.next.next;
            }
            temp = temp.next;
        }
        return head;
    }

    public ListNode reateNmoveDuplicodes2(ListNode head) {
        if(head==null){
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        set.add(head.val);
        while (temp.next != null) {
            if (set.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else {
                set.add(temp.next.val);
                temp = temp.next;

            }
        }
        return head;
    }
}
