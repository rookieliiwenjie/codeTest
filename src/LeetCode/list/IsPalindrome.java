package LeetCode.list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/5 4:29 下午
 * @Description:
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(3);
        ListNode five = new ListNode(3);
        ListNode six = new ListNode(3);
        ListNode seven = new ListNode(1);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;


//        ListNode head = new ListNode(1);
//        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(3);
//        two.next = three;
//        head.next = two;
        // reverseList(head);
        isPalindrome5(head);
    }


    /**
     * 错误版本
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        int num = 0;
        while (head != null) {
            if (!deque.isEmpty() && head.val == deque.peek()) {
                deque.pop();
            } else {
                deque.push(head.val);
            }
            num++;
            head = head.next;
        }
        return num == 1 || deque.isEmpty();
    }

    /**
     * 放入数组再求
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    /**
     * 1先找中间节点
     * 2、反转后半段链表
     * 3、判断是否回文
     * 4、恢复链表
     * 5、返回结果
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome3(ListNode head) {
        if (head == null) {
            return true;
        }
//                 1先找中间节点
//                 2、反转后半段链表
//                 3、判断是否回文
//                 4、恢复链表
//                 5、返回结果

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        //firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode cur = head;
            head = cur.next;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }

    /**
     * 上半年结束
     *
     * @param head 头
     * @return {@link ListNode}
     */
    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    private static ListNode frontPointer;


    public static boolean recoverList(ListNode currNode) {
        if (currNode != null) {
            if (!recoverList(currNode.next)) {
                return false;
            }
            if (frontPointer.val != currNode.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        frontPointer = head;
        return recoverList(head);
    }

    private static ListNode frontPointer2;
    public static boolean isPalindrome5(ListNode head) {
        if (head == null) {
            return false;
        }
        int num = 0;
        frontPointer2 = head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            num++;
        }
        int spa = 0;
        ListNode last = pre;
        while (spa < num/2) {

            spa++;
        }
        return true;
    }

    public static boolean isPalindrome6(ListNode head) {
        if (head == null) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int spa = 0;
        int num = list.size() - 1;
        while (spa < num) {
            if (!list.get(spa).equals(list.get(num))) {
                return false;
            }
            spa++;
            num--;
        }
        return true;
    }


}
