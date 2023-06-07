package org.example.Arrays;

import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMaximumNumber {
    static class Solution {
        public int thirdMaxV2(int[] nums) {
            long h = Long.MIN_VALUE;
            long h1 = Long.MIN_VALUE;
            long h2 = Long.MIN_VALUE;
            for (int num : nums) {
                if (num > h) {
                    h2 = h1;
                    h1 = h;
                    h = num;
                }else if(num > h1 && num != h){
                    h2 = h1;
                    h1 = num;
                }else if(num > h2 && num!= h1 && num != h){
                    h2 = num;
                }
            }
            return h2 == Long.MIN_VALUE ? (int) h : (int) h2;
        }

        public int thirdMax(int[] nums) {
            Set<Integer> list = new HashSet<>();
            for (int num : nums) {
                list.add(num);
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>(3);
            for (Integer i : list) {
                if (queue.isEmpty()) queue.add(i);
                else {
                    if (queue.size() == 3) {
                        if (queue.peek() < i) {
                            queue.poll();
                            queue.add(i);
                        }
                    } else {
                        if (!Objects.equals(queue.peek(), i)) queue.add(i);
                    }
                }
            }

            if (queue.size() == 3) return queue.peek();
            else {
                int result = queue.poll();
                while (!queue.isEmpty()) {
                    result = queue.poll();
                }
                return result;
            }
        }
    }
}
