package org.example.DynamicProgramming;

import java.util.*;

public class Permutations2 {
    static class Solution {
        private List<List<Integer>> solve(int s, Map<Integer, Integer> countMap, List<Integer> curr){
            if(curr.size() == s){
                List<List<Integer>> list = new ArrayList<>();
                list.add(curr);
                return list;
            }

            List<List<Integer>> result = new ArrayList<>();
            for(Integer key : countMap.keySet()){
                if(countMap.get(key) == 0) continue;

                int c = countMap.getOrDefault(key, 0);
                countMap.put(key, (c-1));
                List<Integer> cList = new ArrayList<>(curr);
                cList.add(key);
                List<List<Integer>> temp = solve(s, countMap, cList);
                result.addAll(temp);
                countMap.put(key, c);
            }

            return result;
        }

        public List<List<Integer>> permuteUnique(int[] nums) {
            int size = nums.length;
            Map<Integer, Integer> countMap = new HashMap<>();
            for(Integer i : nums){
                int count = countMap.getOrDefault(i, 0);
                count++;
                countMap.put(i, count);
            }
            List<Integer> curr = new ArrayList<>();
            return solve(size, countMap, curr);
        }
    }
}
