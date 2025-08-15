package LeetCode.list;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class SwapPairs {


    public ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(-1);
        int i = 0;
        ListNode cur = head;
        List<ListNode> listOne = new ArrayList<>();
        List<ListNode> listTwo = new ArrayList<>();
        while (cur != null) {
            if (i % 2 == 0) {
                listOne.add(cur);
            } else {
                listTwo.add(cur);
            }
            cur = cur.next;
            i++;
        }
        ListNode pre = dummy;
        boolean addFlag = false;
        int listOneIndex = 0;
        int listTwoIndex = 0;
        while (listOneIndex < listOne.size() || listTwoIndex < listTwo.size()) {
            if (addFlag) {
                if (listOneIndex < listOne.size()) {
                    pre.next = listOne.get(listOneIndex);
                    pre = pre.next;
                }
                addFlag = false;
                listOneIndex++;
            } else {
                if (listTwoIndex < listTwo.size()) {
                    pre.next = listTwo.get(listTwoIndex);
                    pre = pre.next;
                }
                listTwoIndex++;
                addFlag = true;
            }
        }
        pre.next = null;
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        ListNode pre = head;
        ListNode res = dummy;
        int i = 0;
        while (cur != null) {
            ListNode next = cur.next;
            if (i % 2 == 0) {
                cur.next = null;
                pre = cur;
            } else {
                cur.next = null;
                res.next = cur;
                res = res.next;
                res.next = pre;
                res = res.next;
            }
            cur = next;
            i++;
        }
        if (pre != null) {
            res.next = pre;
            res = res.next;
        }
        res.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.setVal(1);
        ListNode listNode2 = new ListNode();
        listNode2.setVal(2);
        ListNode listNode3 = new ListNode();
        listNode3.setVal(3);
        ListNode listNode4 = new ListNode();
        listNode4.setVal(4);
//        ListNode listNode5 = new ListNode();
//        listNode5.setVal(5);
        ListNode listNode6 = new ListNode();
//        listNode6.setVal(6);
//        listNode5.next = listNode6;
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        SwapPairs swapPairs = new SwapPairs();
        swapPairs.swapPairs(listNode);
//        swapPairs.swapPairsdigui2(listNode);
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //2
        ListNode nextNode = head.next;
        //1
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }

    //迭代的原理就是假设有一个为0的节点
    public ListNode swapPairsdigui(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = head;
        ListNode res = dummy;
        while (temp != null && temp.next != null) {
            ListNode mid = temp.next;
            ListNode next = temp.next.next;
            // 反转两个节点
            mid.next = temp;
            temp.next = null;
            //从2n 开始进行下一次
            temp = next;
            //塞入结果
            res.next = mid;
            //下一次结果以最后一个node继续走
            res = mid.next;

        }
        //如果是基数就进行下一个替换
        if (temp != null) {
            res.next = temp;
        }
        return dummy.next;
    }

    public ListNode swapPairsdigui2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode mid = temp.next;
            ListNode next = temp.next.next;

        }
        return dummy.next;
    }
}
