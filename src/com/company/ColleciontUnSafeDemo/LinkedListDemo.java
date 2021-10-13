package com.company.ColleciontUnSafeDemo;

/**
 * @author rookie.li
 * @date 2021-10-12 20:11
 */
public class LinkedListDemo {
    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * ** 给你单链表的头指针 head 和两个整数 left 和 right ，
     * *  * 其中 left <= right 。
     * *  * 请你反转从位置 left 到位置 right 的链表节点，
     * *  * 返回 反转后的链表 。
     * *  *
     * *  * 示例 1：
     * *  *
     * *  * 输入：head = [1,2,3,4,5], left = 2, right = 4
     * *  * 输出：[1,4,3,2,5]
     * *  ** 示例 2：
     * * <p>
     * * 输入：head = [5], left = 1, right = 1
     * * 输出：[5]
     * * <p>
     * * 提示：
     * * <p>
     * * 链表中节点数目为 n
     * * 1 <= n <= 500
     * * -500 <= Node.val <= 500
     * * 1 <= left <= right <= n
     *
     * @param root
     * @return
     */
//    public ListNode recoverListNode(ListNode root, int left, int right) {
//        ListNode begin = root;
//        ListNode pre = begin;
//        for (int i = 0; i < ; i++) {
//
//        }
//
//
//    }

}
