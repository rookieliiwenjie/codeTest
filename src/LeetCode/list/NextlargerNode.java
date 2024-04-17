package LeetCode.list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/4/10 11:10 上午
 * @Description:
 */
public class NextlargerNode {
  

    public static void main(String[] args) {
        ListNode nextttt = new ListNode();
        nextttt.setVal(5);
        ListNode nexttt = new ListNode();
        nexttt.setVal(3);
        nexttt.setNext(nextttt);
        ListNode nextt = new ListNode();
        nextt.setVal(4);
        nextt.setNext(nexttt);
        ListNode next = new ListNode();
        next.setVal(7);
        next.setNext(nextt);
        ListNode head = new ListNode();
        head.setVal(2);
        head.setNext(next);
        int[] ints = myNextLargerNodesNew(head);
        for (int i = 0; i < ints.length; ++i) {
            System.out.println("ints = " + ints[i]);
        }

//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.push(1);
//        deque.push(2);
//        deque.push(3);
//
//        System.out.println("deque = " + deque.peek());
//        System.out.println("deque = " + deque.peek());
//        System.out.println("deque = " + deque.pop());
//        System.out.println("deque = " + deque.pop());
//        System.out.println("deque = " + deque.pop());

    }

    /**
     * 我们可以理解队列其实是维护的一个弹出从小到的的一个栈，这样就能保证1、最近的比他大的数  2、从小到大， 数组主要是为了记录他们的位置
     * @param head
     * @return
     */
    private static int[] myNextLargerNodesNew(ListNode head) {
       List<Integer> arr = new ArrayList<>();
       //可以为队列也可以为栈 push 和add 的区别
       Deque<int[]> stack = new ArrayDeque<>();
       int index =0;
       while (head!=null){
           arr.add(0);
           while (!stack.isEmpty() && stack.peek()[0]< head.val){
               arr.set(stack.pop()[1],head.val);
           }
           stack.push(new int[]{head.val,index});
           index++;
           head = head.next;
       }
       return arr.parallelStream().mapToInt(Integer::valueOf).toArray();
    }



    private static int[] myNextLargerNodes(ListNode head) {
        List<Integer> arr =  new ArrayList<>();
        ListNode curron = head;
        while (curron != null) {
            if (curron.next == null) {
                arr.add(0);
                break;
            }
            ListNode node = curron.next;
            while (node != null) {
                if (curron.val < node.val) {
                    arr.add(node.val);
                    curron = curron.next;
                    break;
                } else if (node.next == null) {
                    arr.add(0);
                    curron = curron.next;
                    break;
                }
                node = node.next;

            }


        }
        return arr.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> ans = new ArrayList<Integer>();
        Deque<int[]> stack = new ArrayDeque<int[]>();

        ListNode cur = head;
        int idx = -1;
        while (cur != null) {
            ++idx;
            ans.add(0);
            while (!stack.isEmpty() && stack.peek()[0] < cur.val) {
                ans.set(stack.pop()[1], cur.val);
            }
            stack.push(new int[]{cur.val, idx});
            cur = cur.next;
        }

//        int size = ans.size();
//        int[] arr = new int[size];
//        for (int i = 0; i < size; ++i) {
//            arr[i] = ans.get(i);
//        }
        return ans.parallelStream().mapToInt(Integer::valueOf).toArray();
    }
}
