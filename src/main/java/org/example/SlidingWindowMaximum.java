package org.example;

import java.util.*;

public class SlidingWindowMaximum {
    static class Solution {

        public int[] maxSlidingWindowV2(int[] nums, int k){
            StringBuilder builder = new StringBuilder();
            ArrayList<Integer> list = new ArrayList<>();

            Deque<Integer> deque = new ArrayDeque<>();
            int r = 0, l = 0;
            while (r < nums.length){
                if(deque.isEmpty()) deque.add(r);
                else {
                    while (nums[deque.peekLast()] < nums[r]){
                        deque.pollLast();
                    }
                }

                if(l == deque.peekFirst()){
                    deque.pollFirst();
                }

                if(r >= k){
                    k++;
                    list.add(deque.peekFirst());
                }
                r++;
            }
            return list.stream().mapToInt(i->i).toArray();
        }
        public int[] maxSlidingWindow(int[] nums, int k) {
            int maxLength = nums.length - k + 1;
            int[] max = new int[maxLength];

            Map<Integer, Integer> map = new HashMap<>();
            int currentMax = Integer.MIN_VALUE;
            for (int i = 0; i < k; i++){
                int c = map.getOrDefault(nums[i], 0);
                map.put(nums[i], c + 1);

                if(nums[i] > currentMax) currentMax = nums[i];
            }

            int i = 0;
            int j = k;
            while (i < maxLength && j < nums.length){
                max[i] = currentMax;
                int left = nums[i];
                int right = nums[j];

                if(right > currentMax){
                    currentMax = right;
                }else if (left == currentMax && map.get(left) == 1){
                    currentMax = map.keySet()
                            .stream()
                            .mapToInt(v -> v)
                            .max().orElse(currentMax);
                }
                int c = map.getOrDefault(right, 0);
                map.put(right, c + 1);
                map.put(left, map.get(left) - 1);
                i++;
                j++;
            }
            return max;
        }
    }
}
