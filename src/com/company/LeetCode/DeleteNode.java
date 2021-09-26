package com.company.LeetCode;

/**
 * 在此填写类的用途、注意事项等
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author rookie.li
 * @date 2021-09-26 13:04
 */
public class DeleteNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-3);
        ListNode head2 = new ListNode(5);
        head.next = head2;
        ListNode head3 = new ListNode(99);
        head2.next = head3;
        deleteNode(head, -3);
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode lastNode = null;
        ListNode cur = head;
        while (cur != null) {
            //当前删除
            if (cur.val == val) {
                //删除cur；
                lastNode.next = cur.next;
            } else {
                lastNode = cur;
            }
            //终止条件
            cur = cur.next;
        }
        return head;
    }
    public ListNode deleteNode2(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }

}
