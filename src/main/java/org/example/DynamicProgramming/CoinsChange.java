package org.example.DynamicProgramming;

import java.util.HashMap;

public class CoinsChange {
    static class Solution {
        int count(int[] coins, int a, HashMap<Integer, Integer> map){
            if(map.containsKey(a)) return map.get(a);
            if(a == 0) return 0;

            int result = Integer.MAX_VALUE;
            for(int i = 0; i < coins.length; i++){
                int remains = (a - coins[i]);
                if(remains >= 0){
                    int r = 1 + count(coins, remains, map);
                    if(r < result) result = r;
                }
            }
            map.put(a, result);
            return result;
        }

        public int coinChange(int[] coins, int amount) {
            return count(coins, amount, new HashMap<Integer, Integer>());
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.coinChange(new int[]{1, 2, 5}, 11);
    }
}
