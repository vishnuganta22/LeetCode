package org.example.LeetCode;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    static class Solution {
        record Data(long totalDifference, long ladderDifference) {}
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            if(bricks == 0){
                int remainingLadders = ladders;
                int result = 0;
                for (int i = 1; i < heights.length; i++){
                    int diff = heights[i] - heights[i-1];
                    if(diff <= 0) result = i;
                    else{
                        if(remainingLadders > 0){
                            result = i;
                            remainingLadders--;
                        }else{
                            return result;
                        }
                    }
                }
                return result;
            }

            Data[] dataList = new Data[heights.length];
            PriorityQueue<Integer> queue = null;
            if(ladders > 0){
                queue = new PriorityQueue<>(ladders);
            }
            long totalDifference = 0;
            long ladderDifference = 0;
            for (int i = 1; i < heights.length; i++){
                int diff = heights[i] - heights[i-1];
                if(diff > 0) totalDifference += diff;
                if(ladders > 0){
                    if(queue.size() < ladders){
                        if(diff > 0){
                            queue.add(diff);
                            ladderDifference += diff;
                        }
                    }else{
                        if(diff >= queue.peek()){
                            if(diff > 0){
                                int d = queue.poll();
                                ladderDifference -= d;
                                queue.add(diff);
                                ladderDifference += diff;
                            }
                        }
                    }
                }
                dataList[i] = new Data(totalDifference, ladderDifference);
            }

            System.out.println("Queue :: " + queue);

            if(totalDifference <= bricks){
                return heights.length - 1;
            }else{
                for (int i = heights.length - 1; i >= 0; i--){
                    if(dataList[i].totalDifference - dataList[i].ladderDifference <= bricks){
                        return i;
                    }
                }
                return 0;
            }
        }
    }
}
