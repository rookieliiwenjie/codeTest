package com.company.LeetCode.list;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-09-26 21:22
 */
public class MergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1New = l1;
        ListNode l2New = l2;
        ListNode newList = null;
        while (l1New != null && l2New != null) {
        }
        return newList;
    }
}
