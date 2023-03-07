package org.example.LeetCode;

import java.util.Stack;

public class DecodeString {
    static class Solution {
        public String decodeString(String s) {
            return decodeStringV2(s.toCharArray()).toString();
        }

        private StringBuilder decodeStringV2(char[] input){
            Stack<StringBuilder> stringBuilders = new Stack<>();
            Stack<Integer> integers = new Stack<>();

            StringBuilder result = new StringBuilder();
            boolean isInt = false;
            for (char c : input) {
                if (Character.isDigit(c)) {
                    if (isInt){
                        integers.push(integers.pop() * 10 + Character.getNumericValue(c));
                    }else {
                        integers.push(Character.getNumericValue(c));
                    }
                    isInt = true;
                } else if (c == '[') {
                    stringBuilders.push(result);
                    result = new StringBuilder();
                    isInt = false;
                } else if (c == ']') {
                    String stringBuilder = String.valueOf(result).repeat(Math.max(0, integers.pop()));
                    result = stringBuilders.pop().append(stringBuilder);
                    isInt = false;
                } else {
                    result.append(c);
                    isInt = false;
                }
            }
            return result;
        }
    }
}
