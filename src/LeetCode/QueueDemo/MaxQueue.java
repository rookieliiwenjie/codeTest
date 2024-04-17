package LeetCode.QueueDemo;

import java.util.*;

class MaxQueue {
    ArrayList<Integer> queue;   //队列
    Deque<Integer> maxQueue;

    public MaxQueue() {
        queue = new ArrayList<>();
        maxQueue = new ArrayDeque<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        if (maxQueue.isEmpty()) {
            maxQueue.add(value);
        } else {
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(value);
        }
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int pop = queue.get(0);
        queue.remove(0);
        if (!maxQueue.isEmpty() && pop == maxQueue.peekFirst()) {
            maxQueue.removeFirst();

        }
        return pop;
    }
}
