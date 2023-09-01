package org.example.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    static class Solution {
        private List<List<Integer>> solve(int p, int k, int t, List<Integer> cur, int[] arr){
            if(cur.size() >= k && t != 0){
                return new ArrayList<>();
            }
            if(cur.size() == k && t == 0){
                List<List<Integer>> list = new ArrayList<>();
                list.add(cur);
                return list;
            }

            List<List<Integer>> result = new ArrayList<>();
            for(int i = p; i < arr.length; i++){
                int rem = t - arr[i];
                List<Integer> temp = new ArrayList<>(cur);
                temp.add(arr[i]);
                if(rem > 0 && temp.size() < k){
                    List<List<Integer>> res = solve(i + 1, k, rem, temp, arr);
                    result.addAll(res);
                }else if(rem == 0 && temp.size() == k){
                    result.add(temp);
                }
            }
            return result;
        }
        public List<List<Integer>> combinationSum3(int k, int n) {
            int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
            return solve(0, k, n, new ArrayList<>(), arr);
        }
    }
}
