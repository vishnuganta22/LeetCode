package org.example.Arrays;

public class MaxConsecutiveOnes3 {
    static class Solution {
        public int longestOnes(int[] nums, int k) {
            int result = 0;

            int kc = 0;
            int ws = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    kc++;
                }

                int count = i - ws + 1;
                if(kc <= k && count > result){
                    result = count;
                }

                while(kc > k){
                    if(nums[ws] == 0) kc--;
                    ws++;
                }
            }

            return result;
        }
    }
}
