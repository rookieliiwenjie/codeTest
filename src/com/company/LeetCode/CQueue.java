package com.company.LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对appendTail、deleteHead 进行10000次调用
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 *
 * @author rookie.li
 * @date 2021-09-18 18:45
 */
public class CQueue {
    private final Deque<Integer> head = new LinkedList<>();
    private final Deque<Integer> tail = new LinkedList<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        head.add(value);
    }

    /**
     * 解题思路就是head队列只维护进来数据
     * 当有删除的时候，直接加入到tail站中，这样弹出的时候就是一个队列了
     * @return
     */
    public int deleteHead() {
        if (tail.isEmpty()) {
            while (!head.isEmpty()) {
                tail.add(head.pop());
            }
        }
        if (tail.isEmpty()) {
            return -1;
        } else {
            return tail.pop();
        }

    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        int i = cQueue.deleteHead();
        int j = cQueue.deleteHead();
        System.out.println("i = " + i + "" + j);
       /* Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        System.out.println("stack = " + stack.pop());*/
    }
}
