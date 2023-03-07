package org.example.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingQueue {
    static class MyStack {
        private final Deque<Integer> queue = new LinkedList<>();
        public MyStack() {

        }

        public void push(int x) {
            queue.addFirst(x);
        }

        public int pop() {
            return queue.removeFirst();
        }

        public int top() {
            return queue.getFirst();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
