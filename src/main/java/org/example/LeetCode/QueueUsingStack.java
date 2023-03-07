package org.example.LeetCode;

import java.util.Stack;

public class QueueUsingStack {
    static class MyQueue {
        private final Stack<Integer> stack = new Stack<>();
        private final Stack<Integer> reverseStack = new Stack<>();
        public MyQueue() {

        }

        public void push(int x) {
            reverseStack.push(x);
        }

        public int pop() {
            if(!stack.isEmpty()) return stack.pop();
            while (!reverseStack.isEmpty()){
                stack.push(reverseStack.pop());
            }
            return stack.pop();
        }

        public int peek() {
            if(!stack.isEmpty()) return stack.peek();
            while (!reverseStack.isEmpty()){
                stack.push(reverseStack.pop());
            }
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty() && reverseStack.isEmpty();
        }
    }
}
