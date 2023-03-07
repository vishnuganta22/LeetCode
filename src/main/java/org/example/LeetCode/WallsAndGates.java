package org.example.LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WallsAndGates {
    class Solution {
        private void addIndex(int[][] rooms, Queue<Integer> queue, Set<Integer> visitedSet, int m, int n, int i, int j) {
            int index = (i * n) + j;
            if (visitedSet.contains(index) || i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] == -1) return;

            queue.add(index);
            visitedSet.add(index);
        }

        public void wallsAndGates(int[][] rooms) {
            Set<Integer> visitedSet = new HashSet();
            Queue<Integer> queue = new LinkedList();
            int m = rooms.length;
            int n = rooms[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rooms[i][j] == 0) {
                        int index = (i * n) + j;
                        queue.add(index);
                        visitedSet.add(index);
                    }
                }
            }

            int distance = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int index = queue.remove();

                    int a = index / n;
                    int b = index % n;

                    addIndex(rooms, queue, visitedSet, m, n, a - 1, b);
                    addIndex(rooms, queue, visitedSet, m, n, a, b - 1);
                    addIndex(rooms, queue, visitedSet, m, n, a + 1, b);
                    addIndex(rooms, queue, visitedSet, m, n, a, b + 1);
                    rooms[a][b] = distance;
                }
                distance++;
            }
        }
    }
}
