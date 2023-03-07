package org.example.LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }

    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] result = new int[temperatures.length];
            Stack<Temperatures> stack = new Stack<>();
            for (int i = 0; i < temperatures.length; i++){
                while (true){
                    if(!stack.isEmpty() && temperatures[i] > stack.peek().tem){
                        result[stack.peek().index] = i - stack.peek().index;
                        stack.pop();
                    }else {
                        stack.push(new Temperatures(i, temperatures[i]));
                        break;
                    }
                }
            }
            while(!stack.isEmpty()){
                Temperatures tem = stack.pop();
                result[tem.index] = 0;
            }
            return result;
        }
    }

    record Temperatures(int index, int tem) {
    }
}
