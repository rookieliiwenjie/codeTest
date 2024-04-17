package LeetCode;

import LeetCode.list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/8 7:45 下午
 * @Description:
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(8);
        ListNode listNodeA1 = new ListNode(6);
        listNodeA.next = listNodeA1;
//        ListNode listNode2 = new ListNode(1);
//        listNodeA1.next = listNode2;
//        ListNode listNode3 = new ListNode(2);
//        listNode2.next = listNode3;
//        ListNode listNode4 = new ListNode(4);
//        listNode3.next = listNode4;


        ListNode listNodeB = new ListNode(6);
        ListNode listNodeB1 = new ListNode(4);
        listNodeB.next = listNodeB1;
        ListNode listNodeB2 = new ListNode(8);
        listNodeB1.next = listNodeB2;
        addTwoNumber(listNodeA, listNodeB);
    }

    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        List<Integer> l1List = new ArrayList<>();
        List<Integer> l2List = new ArrayList<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                l1List.add(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                l2List.add(l2.val);
                l2 = l2.next;
            }
        }
        ListNode head = new ListNode();
        int l1Len = l1List.size() - 1;
        int l2Len = l2List.size() - 1;
        int preNum = 0;
        while (l1Len >= 0 || l2Len >= 0) {
            ListNode pre = new ListNode();
            if (l1Len >= 0 && l2Len >= 0) {
                head.val = (l1List.get(l1Len) + l2List.get(l2Len) + preNum) % 10;
                preNum = (l1List.get(l1Len) + l2List.get(l2Len) + preNum) / 10;
                l1Len--;
                l2Len--;
            } else if (l1Len >= 0) {
                head.val = (l1List.get(l1Len) + preNum)%10;
                preNum = (l1List.get(l1Len)  + preNum) / 10;
                l1Len--;
            } else {
                head.val = (l2List.get(l2Len) +  preNum) %10;
                preNum = (l2List.get(l2Len)  + preNum) / 10;
                l2Len--;
            }
            pre.next = head;
            head = pre;
        }
        if (preNum != 0) {
            head.val = preNum;
            return head;
        }
        return head.next;

    }
}
