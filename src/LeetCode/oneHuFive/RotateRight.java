package LeetCode.oneHuFive;

import LeetCode.list.ListNode;

public class RotateRight {
    public static void main(String[] args) {
        RotateRight right = new RotateRight();
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 6; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode res = right.rotateRight3(head, 3);

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        k = k % len;
        int right = len - k;
        ListNode rightNode = new ListNode(0);
        ListNode newHead = new ListNode(0);
        rightNode = newHead;
        cur = head;
        while (right > 0) {
            newHead.next = cur;
            cur = cur.next;
            newHead = newHead.next;
            newHead.next = null;
            right--;
        }
        if (cur == null) {
            return rightNode.next;
        }
        ListNode newHeadRight = cur;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = rightNode.next;
        return newHeadRight;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        //如果leng == k
        if (add == n) {
            return head;
        }
        //转化为环形链表
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }

    public ListNode rotateRight3(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int lenght = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            lenght++;
        }
        int right = lenght - k % lenght;// 长度- k
        if (right == lenght) {
            return head;
        }
        //转化为环
        iter.next = head;
        while (right-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;


    }
}
