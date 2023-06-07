package org.example.Arrays;

public class RemoveDuplicatesFromSortedArray {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int result = 0;
            int l = nums.length;
            int p = 0;
            for (int i = 0; i < nums.length; i++){
                if(p != 0 && nums[i] == nums[p-1]){
                    result++;
                }else{
                    nums[p] = nums[i];
                    p++;
                }
            }
            return l - result;
        }
    }
}
