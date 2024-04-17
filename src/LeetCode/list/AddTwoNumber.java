package LeetCode.list;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/3 7:30 下午
 * @Description:
 */
public class AddTwoNumber {
    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(7);
//        ListNode listNode12 = new ListNode(2);
//        listNode1.next = listNode12;
//        ListNode listNode13 = new ListNode(4);
//        listNode12.next = listNode13;
//        ListNode listNode14 = new ListNode(3);
//        listNode13.next = listNode14;
//
//
//
//        ListNode listNode2 = new ListNode(5);
//        ListNode listNode22 = new ListNode(6);
//        listNode2.next = listNode22;
//        ListNode listNode23 = new ListNode(4);
//        listNode22.next = listNode23;


        ListNode listNode1 = new ListNode(1);


        ListNode listNode2 = new ListNode(9);
        ListNode listNode22 = new ListNode(9);
        listNode2.next = listNode22;
        addTwoNumbers(listNode1, listNode2);


    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        while (l1 != null) {
            deque1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            deque2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = new ListNode();
        int yu = 0;
        while (!deque1.isEmpty() || !deque2.isEmpty() || yu != 0) {
            Integer int1 = deque1.isEmpty() ? 0 : deque1.pop();
            Integer int2 = deque2.isEmpty() ? 0 : deque2.pop();
            head.val = (int1 + int2 + yu) % 10;
            yu = (int1 + int2 + yu) / 10;
            ListNode newListNode = new ListNode();
            newListNode.next = head;
            head = newListNode;
        }

        return head.next;

    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }
}
