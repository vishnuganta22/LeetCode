package org.example.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum2 {
    static class Solution {
        private List<List<Integer>> solve(int p, List<int[]> counter, int t, List<Integer> cur){
            if(t < 0) return new ArrayList<>();
            if(t == 0){
                List<List<Integer>> list = new ArrayList<>();
                list.add(cur);
                return list;
            }

            List<List<Integer>> result = new ArrayList<>();
            for(int i = p; i < counter.size(); i++){
                int[] arr = counter.get(i);
                int c = arr[1];
                if(c <= 0) continue;

                c--;
                int r = t - arr[0];
                List<Integer> temp = new ArrayList<>(cur);
                temp.add(arr[0]);
                arr[1] = c;
                counter.set(i, arr);
                if(r > 0){
                    List<List<Integer>> res = solve(i, counter, r, temp);
                    result.addAll(res);
                }else if(r == 0){
                    result.add(temp);
                }
                c++;
                arr[1] = c;
                counter.set(i, arr);
            }
            return result;
        }
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < candidates.length; i++){
                int c = map.getOrDefault(candidates[i], 0);
                c++;
                map.put(candidates[i], c);
            }
            List<int[]> counter = new ArrayList<>();
            map.forEach((integer, integer2) -> counter.add(new int[]{integer, integer2}));
            return solve(0, counter, target, new ArrayList<>());
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
