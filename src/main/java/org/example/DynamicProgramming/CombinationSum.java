package org.example.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static class Solution {
        private List<List<Integer>> solve(int p, int[] nums, int t, List<Integer> cur){
            if(t < 0) {
                return new ArrayList<>();
            }
            if(t == 0){
                List<List<Integer>> list = new ArrayList<>();
                list.add(cur);
                return list;
            }
            List<List<Integer>> result = new ArrayList<>();
            for(int i = p; i < nums.length; i++){
                List<Integer> tCur = new ArrayList<>(cur);
                if((t - nums[i]) > 0){
                    tCur.add(nums[i]);
                    List<List<Integer>> temp = solve(i, nums, (t - nums[i]), tCur);
                    result.addAll(temp);
                }else if((t - nums[i]) == 0){
                    tCur.add(nums[i]);
                    result.add(tCur);
                }
            }
            return result;
        }
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            return solve(0, candidates, target, new ArrayList<>());
        }
    }
}
