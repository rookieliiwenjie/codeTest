package LeetCode.list;

/**
 * @Author: wenjie.li
 * @Date: 2023/7/5 7:18 下午
 * @Description:
 */
public class HasCyCle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(3);
        ListNode five = new ListNode(3);
        ListNode six = new ListNode(2);
        ListNode seven = new ListNode(1);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = three;

        System.out.println("seven = " + hasCycle(null));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && slow.next != null && (fast.next != null && fast.next.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
