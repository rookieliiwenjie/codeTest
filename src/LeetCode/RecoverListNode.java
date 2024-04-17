package LeetCode;

import LeetCode.list.ListNode;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/8 9:34 上午
 * @Description:
 */
public class RecoverListNode {
    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur= head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public Linked_List reverseList2(Linked_List head) {
        Linked_List prev = null;
        Linked_List curr = head;//当前节点
        while (curr != null) {
            Linked_List nextTemp = curr.next;//下一个节点
            curr.next = prev;//将null赋给第二个节点
            prev = curr;//将头节点付给
            curr = nextTemp;//将第二个节点赋格头节点
        }
        return prev;

    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    private static  ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        while (head!=null){
            ListNode cur = head;
            head = cur.next;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }

}
