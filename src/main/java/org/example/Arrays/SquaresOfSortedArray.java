package org.example.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SquaresOfSortedArray {
    static class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] mResult = new int[nums.length];
            int[] result = new int[nums.length];
            int mLength = 0;
            int j = 0;
            for (int i = 0; i < nums.length; i++){
                if(nums[i] < 0){
                    mResult[mLength] = nums[i] * nums[i];
                    mLength++;
                }else{
                    int m = nums[i] * nums[i];
                    int p = mLength - 1;
                    while (p >= 0 && m >= mResult[p]){
                        result[j] = mResult[p];
                        j++;
                        p--;
                        mLength--;
                    }
                    result[j] = m;
                    j++;
                }
            }
            int p = mLength - 1;
            while (p >= 0){
                result[j] = mResult[p];
                j++;
                p--;
                mLength--;
            }
            System.out.println(Arrays.toString(mResult));
            return result;
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] result = solution.sortedSquares(new int[]{-1});
        System.out.println(Arrays.toString(result));
    }
}
