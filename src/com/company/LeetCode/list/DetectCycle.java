package com.company.LeetCode.list;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/22 8:54 下午
 * @Description:
 */
public class DetectCycle {
    /**
     * 1、如何判断是否是环
     * 2、空间复制度如何为1
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return head;
            } else {
                nodeSet.add(head);
            }
            head = head.next;
        }
        return null;
    }

    public static boolean detectCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head.next;
        while (slow != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }


    /**
     * hash表法
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * a+
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle4(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null) {
            if (fast == slow) {
                ListNode pre = head;
                while (fast != pre) {
                    fast = fast.next;
                    pre = pre.next;
                }
                return pre;
            }
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return null;
    }

    public static void main(String[] args) {
        //生成detectCycle2方法的测试用例
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(-4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode1;
        System.out.println(ThreadLocalRandom.current().nextInt(11));

        System.out.println(detectCycle5(listNode));
    }

    public static ListNode detectCycle5(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode pre = head;
                while (slow != pre) {
                    slow = slow.next;
                    pre = pre.next;
                }
                return pre;
            }
        }
        return null;
    }
}


