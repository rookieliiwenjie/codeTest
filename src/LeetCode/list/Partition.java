package LeetCode.list;

public class Partition {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(2);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(partitionNew(listNode, 3));
    }

    public static ListNode partitionNew(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1);
        ListNode largeDummy = new ListNode(-1);
        ListNode smallCur = smallDummy;
        ListNode largeCur = largeDummy;
        ListNode tmep = head;
        while (tmep != null) {
            if (tmep.val < x) {
                smallCur.next = tmep;
                smallCur = smallCur.next;
            } else {
                largeCur.next = tmep;
                largeCur = largeCur.next;
            }
            tmep = tmep.next;
        }
        largeCur.next = null;
        smallCur.next = largeDummy.next;
        return smallDummy.next;
    }

    public ListNode partitionleetCode(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }



    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode beforeHead;
        ListNode before = new ListNode(300);
        beforeHead = before;
        ListNode after = new ListNode(300);
        ListNode afterHead;
        afterHead = after;
        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            if (head.val < x) {
                before.next = newNode;
                before = before.next;
            } else {
                after.next = newNode;
                after = after.next;
            }
            head = head.next;
        }
        before.next = afterHead.next;
        return beforeHead.next;
    }

    public static ListNode partition2(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode beforeHead;
        ListNode before = new ListNode(300);
        beforeHead = before;
        ListNode after = new ListNode(300);
        ListNode afterHead;
        afterHead = after;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        //防止环形
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }


    public static ListNode partition3(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode dummyHead = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                curr.next = dummy.next;
                dummy.next = curr;
                if (dummyHead == dummy) {
                    dummyHead = curr;
                }
            } else {
                dummyHead.next = curr;
                dummyHead = dummyHead.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
