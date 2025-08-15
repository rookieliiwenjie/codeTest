package LeetCode.list;

import java.util.List;

public class RecoverListMid {
    public static void main(String[] args) {
//        ListNode listNode = new ListNode();
//        listNode.setVal(1);
//        ListNode listNode2 = new ListNode();
//        listNode2.setVal(2);
//        ListNode listNode3 = new ListNode();
//        listNode3.setVal(3);
//        ListNode listNode4 = new ListNode();
//        listNode4.setVal(4);
//        ListNode listNode5 = new ListNode();
//        listNode5.setVal(5);
//        ListNode listNode6 = new ListNode();
//        listNode6.setVal(6);
//        listNode5.next = listNode6;
//        listNode.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        ListNode listNode = new ListNode();
        listNode.setVal(3);
        ListNode listNode2 = new ListNode();
        listNode2.setVal(5);
        listNode.next = listNode2;
        RecoverListMid recoverListMid = new RecoverListMid();
        recoverListMid.reverseBetween(listNode, 1, 2);

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy.next;
        int begin = 1;
        int revocreNUm = right - left;
        ListNode beginNode = dummy;
        while (cur != null) {
            if (begin == left) {
                ListNode pre = null;
                //反转数据
                while (revocreNUm >= 0) {
                    ListNode next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                    revocreNUm--;
                }
                beginNode.next = pre;
                while (pre.next != null) {
                    pre = pre.next;
                }
                pre.next = cur;
                break;
            }
            begin++;
            beginNode = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 后话一般
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        for (int i = 0; i < left; i++) {
            cur = cur.next;
        }
        ListNode reco = cur;
        int num = left - right + 1;
        ListNode next = null;
        for (int i = 0; i <= num; i++) {
            reco = reco.next;
        }
//        num = reco;
        return dummy.next;
    }

    public ListNode recoverListNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

        }
        return cur;
    }

}
