package org.example.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    static class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < matrix.length; i++){
                for (int j = 0; j < matrix.length; j++){
                    queue.add(matrix[i][j]);
                }
            }

            int n = matrix.length;
            int p = (n * n) - k + 1;

            int result = -1;
            while (p != 0){
                result = queue.poll();
                p--;
            }
            return result;
        }
    }
}
