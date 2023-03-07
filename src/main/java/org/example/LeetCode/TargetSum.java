package org.example.LeetCode;

import java.util.HashMap;

public class TargetSum {
    static class Solution {
        record Data(int index, int target) {
            @Override
            public int hashCode() {
                return (index + "," + target).hashCode();
            }

        }

        public int findTargetSumWays(int[] nums, int target) {
            HashMap<Data, Integer> map = new HashMap<>();
            return findTargetSumWaysUtils(nums, target, 0, 0, map);
        }

        private int findTargetSumWaysUtils(int[] nums, int finalTarget, int index, int target, HashMap<Data, Integer> map){
            if(index == nums.length) return finalTarget == target ? 1 : 0;

            Data data = new Data(index, target);
            if(map.containsKey(data)) return map.get(data);
            map.put(data, findTargetSumWaysUtils(nums, finalTarget, index + 1, target + nums[index], map) + findTargetSumWaysUtils(nums, finalTarget, index + 1, target - nums[index], map));
            return map.get(data);
        }
    }
}
