package com.company.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lwj32 on 2020/5/16.
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode() {

        }
    }

   /* public static void main(String[] args) {
        int nums[] = new int[]{1};
        int i = search(nums, 1);
        System.out.println("i = " + i);
    }*/

    // 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
    public ListNode reverseList2(ListNode head) {
        /**
         * 因为最后一个节点的next一定为空，所有我想将最后一个节点的next替换为倒数第二
         * 所以我需要判断啥时候为空
         */
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //1.节点下一个值要给
            ListNode next = curr.next;
            //新的链表赋值给当前节点的下一个节点
            curr.next = prev;
            //
            prev = curr;

            curr = next;
        }
        return prev;

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cru = head;
        while (cru != null) {
            ListNode next = cru.next;
            cru.next = pre;
            pre = cru;
            cru = next;
        }
        return pre;
    }

    public Linked_List reverseList(Linked_List head) {
        Linked_List prev = null;
        Linked_List curr = head;//当前节点
        while (curr != null) {
            Linked_List nextTemp = curr.next;//下一个节点
            curr.next = prev;//将null赋给第二个节点
            prev = curr;//将头节点付给
            curr = nextTemp;//将第二个节点赋格头节点
        }
        return prev;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * <p>
     * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
     *
     * @return
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(9);
        TreeNode rootRight = new TreeNode(20);
        root.left = rootLeft;
        root.right = rootRight;
        TreeNode rootRightLeft = new TreeNode(15);
        TreeNode rootRightRight = new TreeNode(7);
        rootRight.right = rootRightRight;
        rootRight.left = rootRightLeft;
        List<List<Integer>> list = levelOrder(root);
        System.out.println("list = " + list);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> newList = new ArrayList<>();
            //需要终止poll
            /*int size = queue.size();
            for (int i = 0; i < size; i++) {*/
            //这里是赋值
            for (int i = queue.size(); i > 0; i--) {
                System.out.println("i = " + i);
                TreeNode poll = queue.poll();
                newList.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                System.out.println("i = " + i);
            }
            list.add(newList);
        }
        return list;
    }

//    public static void main(String[] args) {
//        int nums[] = {-1, 0, 3, 5, 9, 12};
//        int indx = searchB(nums, 9);
//        System.out.println("indx = " + indx);
//    }

    public static int searchB(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = (left + right) / 2;
            if (target < nums[index]) {
                right = index - 1;
            } else if (target > nums[index]) {
                left = index + 1;
            } else {
                return index;
            }
        }
        return -1;
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

   /* public static void main(String[] args) {
        int nums[] = new int[]{1};
        int i = search(nums, 1);
        System.out.println("i = " + i);
    }*/

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
