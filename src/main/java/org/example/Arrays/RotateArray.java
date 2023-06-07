package org.example.Arrays;

public class RotateArray {
    static class Solution {
        public void rotate(int[] nums, int k) {
            int ck = k;
            if(nums.length < k){
                ck = k % nums.length;
            }
            int i = 0;
            int j = nums.length - 1;
            while(i < j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }

            i = 0;
            j = ck - 1;
            while(i < j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }

            i = ck;
            j = nums.length - 1;
            while(i < j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
        }
    }
}
