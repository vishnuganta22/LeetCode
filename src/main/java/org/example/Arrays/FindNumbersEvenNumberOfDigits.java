package org.example.Arrays;

public class FindNumbersEvenNumberOfDigits {
    class Solution {
        private boolean isEvenCount(int num){
            int count = 0;
            int i = num;
            while (i > 0){
                i = i / 10;
                count++;
            }
            return count % 2 == 0;
        }
        public int findNumbers(int[] nums) {
            int result = 0;
            for (int i = 0; i < nums.length; i++){
                if(isEvenCount(nums[i])){
                    result++;
                }
            }
            return result;
        }
    }
}
