package org.example.Arrays;

import java.util.Arrays;

public class ArrayPartition {
    static class Solution {
        public int arrayPairSum(int[] nums) {
            int result = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i = i + 2){
                result += nums[i];
            }
            return result;
        }
    }
}
