package org.example.Arrays;

public class MergeSortedArrays {
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 10, 11, 17
            // 1, 7, 9
            int w = m + n - 1;
            int r1 = m - 1;
            int r2 = n - 1;
            while (r1 >= 0 || r2 >= 0){
                if(r2 < 0){
                    nums1[w] = nums1[r1];
                    w--;
                    r1--;
                }else if(r1 < 0){
                    nums1[w] = nums2[r2];
                    w--;
                    r2--;
                }else if(nums1[r1] > nums2[r2]){
                    nums1[w] = nums1[r1];
                    w--;
                    r1--;
                }
                else{
                    nums1[w] = nums2[r2];
                    w--;
                    r2--;
                }
            }
        }
    }
}
