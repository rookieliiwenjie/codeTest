package LeetCode;

import LeetCode.list.ListNode;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/5 7:46 下午
 * @Description:
 */
public class GetIntersectTionNode {
    public static ListNode  getIntersectTionNode(ListNode headA,ListNode headB){
        ListNode headACurron = headA;
        ListNode headBCurron = headB;
        while (headACurron!=null && headBCurron!=null ){
            if (headA == null ) {
                headB = headBCurron.getNext();
                headBCurron = headBCurron.getNext();
                headA=headACurron;
            }
            if (headA.getVal() == headB.getVal()) {
                return headA;
            }
            headA = headA.getNext();
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode nextttt = new ListNode();
        nextttt.setVal(5);
        ListNode nexttt = new ListNode();
        nexttt.setVal(3);
        nexttt.setNext(nextttt);
        ListNode nextt = new ListNode();
        nextt.setVal(2);
        nextt.setNext(nexttt);
        ListNode next = new ListNode();
        next.setVal(7);
        next.setNext(nextt);

        ListNode head = new ListNode();
        head.setVal(1);
        head.setNext(next);
        ListNode head2 = new ListNode();
        head2.setVal(2);
        head.setNext(head2);
        getIntersectTionNode(next,head);
    }
}
