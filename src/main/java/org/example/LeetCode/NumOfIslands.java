package org.example.LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumOfIslands {
    class Solution {
        private void addIndex(char[][] grid, Queue<Integer> queue, Set<Integer> visitedSet, int m, int n, int i, int j) {
            int index = (i * n) + j;
            if (visitedSet.contains(index) || i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;

            queue.add(index);
            visitedSet.add(index);
        }

        public int numIslands(char[][] grid) {
            int m = grid.length;
            if(m == 0) return 0;

            int n = grid[0].length;
            if (n == 0) return 0;

            Set<Integer> visitedNodes = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();

            int numOfIslands = 0;
            for(int i = 0; i < n * m; i++){
                int a = i / n;
                int b = i % n;
                addIndex(grid, queue, visitedNodes, m, n, a, b);

                int size = queue.size();
                if(size > 0) numOfIslands++;
                while (!queue.isEmpty()){
                    int index = queue.remove();
                    int p = index / n;
                    int q = index % n;

                    addIndex(grid, queue, visitedNodes, m, n, p - 1, q);
                    addIndex(grid, queue, visitedNodes, m, n, p, q - 1);
                    addIndex(grid, queue, visitedNodes, m, n, p + 1, q);
                    addIndex(grid, queue, visitedNodes, m, n, p, q + 1);
                }
            }
            return numOfIslands;
        }
    }
}
