package org.example;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxProfit {
    static class Solution {
        public int maxProfit(int[] prices) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(2, Collections.reverseOrder());
            int initV = prices[0];
            int prev = prices[0];
            boolean shouldContinue = false;
            for(int i = 1; i < prices.length; i++){
                if(prev < prices[i]){
                    shouldContinue = true;
                }else{
                    queue.add(prev - initV);
                    initV = prices[i];
                }
                prev = prices[i];
            }
            if(shouldContinue) queue.add(prev - initV);

            int result = 0;
            while (!queue.isEmpty()){
                result += queue.poll();
            }
            return result;
        }
    }
}
