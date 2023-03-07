package org.example.LeetCode;

import java.util.Stack;

public class ReversePolishNotation {
    static class Solution {
        private boolean isOperator(String value){
            return ((value.equals("+") || value.equals("*") || value.equals("/") || value.equals("-")));
        }

        private int performOperation(String operator, int val1, int val2){
            return switch (operator) {
                case "+" -> val1 + val2;
                case "-" -> val1 - val2;
                case "*" -> val1 * val2;
                default -> val1 / val2;
            };
        }

        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                if (isOperator(token)) {
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    stack.push(performOperation(token, val1, val2));
                } else {
                    stack.push(Integer.valueOf(token));
                }
            }
            return stack.peek();
        }
    }
}
