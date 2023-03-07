package org.example.LeetCode;

import java.util.Stack;

public class MinStack {
    private final Stack<Integer> arrayList;
    private final Stack<Integer> minList;
    public MinStack() {
        this.arrayList = new Stack<>();
        this.minList = new Stack<>();
    }

    public void push(int val) {
        this.arrayList.push(val);
        if(this.minList.isEmpty() || val < this.minList.peek()) this.minList.push(val);
        else this.minList.push(this.minList.peek());
    }

    public void pop() {
        this.arrayList.pop();
        this.minList.pop();
    }

    public int top() {
        return this.arrayList.peek();
    }

    public int getMin() {
        return minList.peek();
    }
}
