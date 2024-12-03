package LeetCode.zhan;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private Deque<Integer> queue;
    private Deque<Integer> minQueue;

    public MinStack() {
        this.minQueue = new ArrayDeque<>();
        this.queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
        int min = minQueue.peek();
        if (x < min || minQueue.isEmpty()) {
            minQueue.addFirst(x);
        } else {
            minQueue.addFirst(min);
        }
        queue.addFirst(x);
    }

    public void pop() {

    }

    public int top() {

    }

    public int getMin() {

    }

}
