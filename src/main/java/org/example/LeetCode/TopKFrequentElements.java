package org.example.LeetCode;

import java.util.*;

public class TopKFrequentElements {
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++){
                if(countMap.containsKey(nums[i])){
                    int count = countMap.get(nums[i]);
                    count++;
                    countMap.put(nums[i], count);
                }else{
                    countMap.put(nums[i], 1);
                }
            }

            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
                if (Objects.equals(o1.getValue(), o2.getValue()))
                    return 0;
                else if (o1.getValue() < o2.getValue())
                    return 1;
                else
                    return -1;
            });

            queue.addAll(countMap.entrySet());

            int[] result = new int[k];
            for (int i = 0; i < k; i++){
                Map.Entry<Integer, Integer> entry = queue.poll();
                if(entry != null){
                    result[i] = entry.getKey();
                }else{
                    result[i] = -1;
                }
            }
            return result;
        }
    }
}
