package org.example.LeetCode;

import java.util.*;

public class PerfectSquares {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.print(solution.numSquares(12));
    }
    static class Solution {
        private int getSquare(int n) {
            return n * n;
        }

        public int numSquares(int n) {
            int sqrt = (int) Math.floor(Math.sqrt(n));
            if (getSquare(sqrt) == n) return 1;

            HashMap<Integer, Integer> set = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();
            int distance = 0;
            queue.add(0);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int num = queue.remove();
                    for (int j = 1; j <= sqrt; j++) {
                        int sqr = getSquare(j);
                        if((sqr + num) <= n && !set.containsKey(sqr + num)){
                            queue.add(sqr + num);
                            set.put(sqr + num, distance + 1);
                        }
                    }
                }
                distance = distance + 1;
            }
            return set.get(n);
        }
    }
}
