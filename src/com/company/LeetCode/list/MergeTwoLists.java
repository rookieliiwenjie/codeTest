package com.company.LeetCode.list;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-09-26 21:22
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        l1.next = l12;
        ListNode l13 = new ListNode(4);
        l12.next = l13;
        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        l2.next = l22;
        ListNode l23 = new ListNode(4);
        l22.next = l23;
        mergeTwoLists(l1, l2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dum = new ListNode(0), cur = dum;
        while (l1 != null || l2 != null) {
            if (l1 == null || l2 == null) {
                cur.next = l1 != null ? l1 : l2;
                return dum.next;
            } else if (l1.val > l2.val) {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            cur = cur.next;
        }
        return dum.next;
    }
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;


    }
}
