package LeetCode.zhan;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈，使用辅助可以实现
 */
public class MinStack {
    private Deque<Integer> queue;
    private Deque<Integer> minQueue;

    public MinStack() {
        this.minQueue = new ArrayDeque<>();
        this.queue = new ArrayDeque<>();
    }

    public void push(int x) {
        int min = minQueue.isEmpty() ? Integer.MAX_VALUE : minQueue.peek();
        if (x < min) {
            minQueue.addFirst(x);
        } else {
            minQueue.addFirst(min);
        }
        queue.addFirst(x);
    }

    public void pop() {
        queue.removeFirst();
        minQueue.removeFirst();
    }

    public int top() {
        return queue.getFirst();
    }

    public int getMin() {
        return minQueue.getFirst();
    }

    class MinStack2 {
        Deque<Integer> xStack;
        Deque<Integer> minStack;

        public MinStack2() {
            xStack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
