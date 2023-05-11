package org.example.LeetCode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumCostConnectSticks {
    static class Solution {
        public int connectSticks(int[] sticks) {
            if(sticks.length <= 1) return 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < sticks.length; i++){
                queue.add(sticks[i]);
            }

            ArrayList<Integer> costs = new ArrayList<>();
            while (queue.size() > 1){
                int x = queue.poll();
                int y = queue.poll();
                costs.add(x + y);
                queue.add(x+y);
            }

            int result = 0;
            for (Integer i: costs){
                result = result+i;
            }
            return result;
        }
    }
}
