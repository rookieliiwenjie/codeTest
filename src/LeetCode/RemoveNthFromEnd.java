package LeetCode;

import LeetCode.list.ListNode;

import java.util.HashMap;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/6 4:14 下午
 * @Description:
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
//        ListNode nextttt = new ListNode();
//        nextttt.setVal(5);
//        ListNode nexttt = new ListNode();
//        nexttt.setVal(3);
//        nexttt.setNext(nextttt);
        ListNode nextt = new ListNode();
       nextt.setVal(2);
        //nextt.setNext(nexttt);
        ListNode next = new ListNode();
        next.setVal(7);
       next.setNext(nextt);
        removeNthFromEnd2(next,1);
    }

    public static ListNode removeNthFromEnd2(ListNode head,int n ){
        ListNode newHead = new ListNode();
        newHead.next = head;
        HashMap<Integer,ListNode> hashMap = new HashMap<>();
        int i = 1;
        while (head != null) {
            hashMap.put(i,head);
            i++;
            head = head.next;
        }
        int index = (hashMap.size() - n) > 0 ? (hashMap.size() - n) : 1;
        if (n == hashMap.size()) {
            return newHead.next.next;
        }
        ListNode pre = hashMap.get(index);
        pre.next = hashMap.get((index +2));
        return newHead.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        int lenght = getLength(head);
        ListNode curr = newHead;
        for (int i = 1; i < lenght - n + 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return newHead.next;
    }


    public static int getLength(ListNode head){
        int lenght = 0;
        while (head != null) {
            head = head.next;
            lenght++;
        }
        return lenght;
    }
}
