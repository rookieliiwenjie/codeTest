package com.company.LeetCode;

/**
 * Created by lwj32 on 2020/5/16.
 */
//反转链表
public class RevserLitst {
 /*   public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] revserArr = new int[5];
        for (int i = 0; i < arr.length; i++) {

        }

    }*/

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node headNow = head;
        Node headx = head;
        while (head.next != null) {
            headNow.next = headx.next;
            headx = head.next;
            headNow.random = copyRandomList(head);
        }
        return headNow;
    }

    public String replaceSpace(String s) {
        if (s.isEmpty()) {
            return s;
        }
        return s.replace(" ", "%20");
    }

    public String reverseLeftWords(String s, int n) {
        if (s.isEmpty() || n > s.length()) {
            return s;
        }
        return s.substring(n, s.length()) + s.substring(0, n);
    }


    // 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
    public Linked_List reverseList2(Linked_List head) {
        Linked_List headBefore = head;
        Linked_List headnow = null;
        /**
         * 因为最后一个节点的next一定为空，所有我想将最后一个节点的next替换为倒数第二
         * 所以我需要判断啥时候为空
         */
        while (headBefore.next != null) {
            Linked_List next = headBefore.next;
            headnow = next;

        }
        return headnow;

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

    /* 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            int swap = nums[i];
            nums[i] = nums[swap];
            nums[swap] = swap;


        }
        return -1;
    }

    public static int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;

    }

    public static void main(String[] args) {
        int nums[] = new int[]{1};
        int i = search(nums, 1);
        System.out.println("i = " + i);
    }

    public static int search(int[] nums, int target) {
        int num = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == target) {
                num++;
            }
            if (nums[right] == target && left != right) {
                num++;
            }
            left++;
            right--;

        }
        return num;
    }


}
