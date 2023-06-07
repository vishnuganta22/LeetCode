package org.example.Arrays;

public class MaxConsecutiveOnes {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int result = 0;
            int c = 0;
            for (int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    if(c > result){
                        result = c;
                    }
                    c = 0;
                }else{
                    c++;
                }
            }
            if(c > result){
                result = c;
            }
            return result;
        }
    }
}
