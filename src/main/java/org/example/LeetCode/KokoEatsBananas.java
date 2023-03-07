package org.example.LeetCode;

import java.util.Arrays;

public class KokoEatsBananas {
    class Solution {
        private int getFloorDiv(int x, int y){
            if(x % y == 0){
                return x / y;
            }else{
                return (x / y) + 1;
            }
        }

        private int findMin(int[] piles, int min, int max, int h, int res){
            if(min > max) return res;

            int mid = (min + max) / 2;
            long total = 0;
            for (int pile : piles) {
                total = total + getFloorDiv(pile, mid);
            }
            if(total > h){
                return findMin(piles, mid + 1, max, h, res);
            }else {
                return findMin(piles, min, mid - 1, h, Math.min(res, mid));
            }
        }

        public int minEatingSpeed(int[] piles, int h) {
            Arrays.sort(piles);
            if(piles.length > h) return -1;
            else if (piles.length == h) return piles[piles.length - 1];
            else{
                int max = piles[piles.length - 1];
                return findMin(piles, 1, max, h, max);
            }
        }
    }
}
