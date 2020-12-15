package com.company.LeetCode;

/**
 * Created by lwj32 on 2020/5/16.
 */
//反转链表
public class RevserLitst {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] revserArr = new int[5];
        for (int i = 0; i < arr.length; i++) {

        }

    }

    public Linked_List reverseList(Linked_List head) {
        Linked_List prev = null;

        Linked_List curr = head;//头节点
        while (curr != null) {
            Linked_List nextTemp = curr.next;//头节点的下个节点 付给next
            curr.next = prev;//将null赋给第二个节点
            prev = curr;//将头节点付给
            curr = nextTemp;//将第二个节点赋格头节点
        }
        return prev;

    }
}
