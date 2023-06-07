package org.example.Arrays;

import java.util.Stack;

public class ReverseWordsInString {
    static class Solution {
        public String reverseWords(String s) {
            char[] arr = s.toCharArray();
            Stack<String> stack = new Stack<>();
            boolean isWordStarted = false;
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == ' '){
                    if(isWordStarted){
                        if(!builder.isEmpty()) stack.push(builder.toString());
                        builder = new StringBuilder();
                    }
                    isWordStarted = false;
                }else{
                    builder.append(arr[i]);
                    if(i == arr.length - 1){
                        if(!builder.isEmpty()) stack.push(builder.toString());
                    }
                    isWordStarted = true;
                }
            }

            StringBuilder result = new StringBuilder();
            while(!stack.isEmpty()){
                result.append(stack.pop());
                if(!stack.isEmpty()) result.append(" ");
            }
            return result.toString();
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(" hello world "));
    }
}
