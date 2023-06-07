package org.example.Arrays;

import java.util.Arrays;

public class MinimumSizeSubarraySum {
    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int result = Integer.MAX_VALUE;
            int ws = 0;
            int sum = 0;
            for (int i = 0; i < nums.length; i++){
                sum += nums[i];
                if(sum >= target && (i - ws + 1) < result){
                    result = i - ws + 1;
                }
                while (sum > target && ws < i){
                    sum -= nums[ws];
                    ws++;
                    if(sum >= target && (i - ws + 1) < result){
                        result = i - ws + 1;
                    }
                }
            }
            return result > nums.length ? 0 : result;
        }
    }
}
