package LeetCode;

import java.util.ArrayList;

/**
 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 示例 1：
 *
 输入：head = [1,3,2]
 输出：[2,3,1]
 *
 @author rookie.li
 @date 2021-09-16 10:50
 */
public class ReversePrint{

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(2);
        head.next = two;
        two.next = three;
        //4,3,2 输出2,3,4
        int[] ints = reversePrint(head);
        System.out.println("ints = " + ints);

    }

    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode next = head.next;
        list.add(head.val);
        while (next != null) {
            list.add(next.val);
            next = next.next;
        }
        int[] arr = new int[list.size()];
        int j = 0;
        for (int i = list.size() - 1; i >= 0; i--, j++) {
            arr[j] = list.get(i);
        }
        return arr;

    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
