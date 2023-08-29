package org.example.DynamicProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {
    static class Solution {
        private List<List<Integer>> solve(int s, Set<Integer> set, List<Integer> cur){
            if(cur.size() == s){
                List<List<Integer>> list = new ArrayList<>();
                list.add(cur);
                return list;
            }

            List<List<Integer>> result = new ArrayList<>();
            for(Integer i : set){
                Set<Integer> cSet = new HashSet<>(set);
                List<Integer> cList = new ArrayList<>(cur);
                cSet.remove(i);
                cList.add(i);
                List<List<Integer>> temp = solve(s, cSet, cList);
                result.addAll(temp);
            }
            return result;
        }

        public List<List<Integer>> permute(int[] nums) {
            int size = nums.length;
            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            return solve(size, set, new ArrayList<>());
        }
    }
}
