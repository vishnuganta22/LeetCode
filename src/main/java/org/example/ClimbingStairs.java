package org.example;

public class ClimbingStairs {
    static class Solution {
        public int climbStairs(int n) {
            if (n == 1) return 1;
            int nums[] = new int[n + 1];
            nums[0] = 2;
            nums[1] = 3;
            for (int i = 2; i <= n; i++){
                nums[i] = nums[i - 1] + nums[i - 2];
            }
            return nums[n - 2];
        }
    }
}
