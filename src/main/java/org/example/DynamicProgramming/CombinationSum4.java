package org.example.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CombinationSum4 {
    static class Solution {
        private int solve(int t, int[] nums, Map<Integer, Integer> map){
            if(map.containsKey(t)) return map.get(t);
            if(t == 0) return 1;
            if(t < 0) return 0;
            int result = 0;
            for(int i = 0; i < nums.length; i++){
                result += solve((t - nums[i]), nums, map);
            }
            map.put(t, result);
            return result;
        }
        public int combinationSum4(int[] nums, int target) {
            return solve(target, nums, new HashMap<>());
        }
    }
}
