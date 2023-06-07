package org.example.Arrays;

public class RemoveElement {
    static class Solution {
        public int removeElement(int[] nums, int val) {
            int result = 0;
            int l = nums.length;
            int p = 0;
            for (int i = 0; i < nums.length; i++){
                if(nums[i] == val){
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
