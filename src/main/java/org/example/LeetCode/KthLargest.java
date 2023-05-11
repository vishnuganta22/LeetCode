package org.example.LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < nums.length; i++){
                queue.add(nums[i]);
            }

            int result = -1;
            for (int i = 0; i < k; i++){
                result = queue.poll();
            }

            return result;
        }
    }
}
