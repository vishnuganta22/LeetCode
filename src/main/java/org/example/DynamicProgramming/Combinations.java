package org.example.DynamicProgramming;

import java.util.*;

public class Combinations {
    static class Solution {
        private List<List<Integer>> solve(int s, int n, int k, List<Integer> curr){
            if(curr.size() == k) return new ArrayList<>();

            List<List<Integer>> result = new ArrayList<>();
            for(int i = s; i <= n; i++){
                ArrayList<Integer> newCurr = new ArrayList<>(curr);
                newCurr.add(i);
                if(newCurr.size() == k){
                    result.add(newCurr);
                }else{
                    List<List<Integer>> temp = solve(i + 1, n, k, newCurr);
                    result.addAll(temp);
                }
            }
            return result;
        }

        public List<List<Integer>> combine(int n, int k) {
            return solve(1, n, k, new ArrayList<Integer>());
        }
    }
}
