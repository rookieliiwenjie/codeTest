package LeetCode.list;

import java.util.*;

/**
 * @author liuyuhang
 */
public class ReOrderList {
    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(1);
        ListNode listNodeA1 = new ListNode(2);
        ListNode listNodeA11 = new ListNode(3);
        ListNode listNodeA111 = new ListNode(4);
        listNodeA.next = listNodeA1;
        listNodeA1.next = listNodeA11;
        listNodeA11.next = listNodeA111;
//        ListNode listNode2 = new ListNode(1);
//        listNodeA1.next = listNode2;
//        ListNode listNode3 = new ListNode(2);
//        listNode2.next = listNode3;
//        ListNode listNode4 = new ListNode(4);
//        listNode3.next = listNode4;
        reorderList3(listNodeA);

    }

    public static void reorderList(ListNode head) {
        //两个链表可以解决
        LinkedList<ListNode> listNodes = new LinkedList<>();
        ArrayDeque<ListNode> listNodesSecond = new ArrayDeque<>();
        int index = 0;
        while (head != null) {
            if (index % 2 == 0) {
                listNodes.offer(head);
            } else {
                listNodesSecond.offer(head);
            }
            index++;
            head = head.next;
        }
        //1,2,3,4
        //1,4,2,3
        //1,2,3,4,5
        //1,5,2,4,3
        while (!listNodesSecond.isEmpty() || !listNodes.isEmpty()) {
            //先进后出
            ListNode first = listNodes.isEmpty() ? null : listNodes.poll();
            //先进先出
            ListNode second = listNodesSecond.isEmpty() ? null : listNodesSecond.poll();
            ListNode curron = new ListNode();
            if (first != null) {
                curron = head;
                head = first;
                head.next = curron;
            }
            if (second != null) {
                curron = head;
                head = second;
                head.next = curron;
            }
        }
        System.out.println(head);
    }

    public static void reorderList2(ListNode head) {
        //两个链表可以解决
        HashMap<Integer, ListNode> listNodes = new HashMap<>();
        int index = 0;
        while (head != null) {
            listNodes.put(index, head);
            index++;
            head = head.next;
        }
        //1,2,3,4
        //1,4,2,3
        //1,2,3,4,5
        //1,5,2,4,3
        int x = index / 2 + 1;
        int y = index;
        while (x <= index) {
            ListNode curron = new ListNode();
            curron = listNodes.get(x);
            x--;
        }
    }

    //1,2,3,4
    //1,4,2,3
    //1,2,3,4,5
    //1,5,2,4,3
    public static void reorderList3(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            listNodes.add(node);
            node = node.next;
        }
        int left = 0, right = listNodes.size() - 1;
        while (left < right) {
            listNodes.get(left).next = listNodes.get(right);
            left++;
            if (left == right) {
                break;
            }
            listNodes.get(right).next = listNodes.get(left);
            right--;
        }
        listNodes.get(left).next = null;
    }

    public void reorderList4(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
