package org.example.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    static class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < stones.length; i++){
                queue.add(stones[i]);
            }

            while (true){
                if(queue.size() == 1){
                    return queue.poll();
                }else if(queue.size() == 0){
                    return 0;
                }else{
                    int y = queue.poll();
                    int x = queue.poll();
                    if(x != y){
                        queue.add(y - x);
                    }
                }
            }
        }
    }
}
