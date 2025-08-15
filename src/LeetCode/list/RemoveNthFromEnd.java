package LeetCode.list;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class RemoveNthFromEnd {


    /**
     * 两次反转
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode rev = pre;
        int num = 1;
        ListNode pre2 = null;
        //再次反转
        while (rev != null) {
            if (num == n) {
                rev = rev.next;
            } else {
                ListNode next = rev.next;
                //反转指针
                rev.next = pre2;
                pre2 = rev;
                rev = next;
            }
            num++;
        }
        return pre2;
    }

    /**
     * 记录链表数
     * 计算链表长度方法 OL
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int listLenght = 0;
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = head;
        while (cur != null) {
            listLenght++;
            cur = cur.next;
        }
        ListNode newNode = dummy;
        int num = listLenght - n;
        while (num > 0) {
            newNode = newNode.next;
            num--;
        }
        newNode.next = newNode.next.next;
        return dummy.next;
    }

    /**
     * 栈方式
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode cur = dummy;
        while (cur != null) {
            deque.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            deque.pop();
        }
        ListNode nthNode = deque.peek();
        nthNode.next = nthNode.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        int n = 2;
//        ListNode listNode = new ListNode(1);
//        int n = 1;
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode listNode5 = removeNthFromEnd.removeNthFromEnd4(listNode, n);
    }

    /**
     * 双指针
     * 一个快一个慢 长度是n+1的长度
     * 当快的结束时，正好在删除节点的前一个节点。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd4(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode first = dummy;
        ListNode sencond = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            sencond = sencond.next;
        }
        sencond.next = sencond.next.next;
        return dummy.next;
    }
}
