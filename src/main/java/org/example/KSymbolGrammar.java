package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KSymbolGrammar {
    class Solution {
        // Time limit exceeded for this solution
        public int kthGrammarFailed(int n, int k) {
            if(k == 1) return 0;

            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);

            int cur = 1;
            while(list.size() < k){
                if(list.get(cur) == 0){
                    list.add(0);
                    list.add(1);
                }else{
                    list.add(1);
                    list.add(0);
                }
                cur += 1;
            }
            return list.get(k-1);
        }

        public int kthGrammar(int n, int k) {
            if (k == 1) return 0;
            if (k == 2) return 1;

            Stack<Integer> stack = new Stack<>();
            int t = k;
            stack.push(t);
            while (true){
                if( t == 1 || t == 2) {
                    break;
                }

                if(t % 2 == 0){
                    t = t / 2;
                    stack.push(t);
                }else{
                    t = (t + 1) / 2;
                    stack.push(t);
                }
            }

            int f = stack.pop();
            int prev = f == 1 ? 0 : 1;
            while (!stack.isEmpty()){
                int i = stack.pop();

                if(i % 2 == 0){
                    if (prev == 1) prev = 0;
                    else prev = 1;
                }else{
                    if (prev == 1) prev = 1;
                    else prev = 0;
                }
            }

            return prev;
        }
    }
}
