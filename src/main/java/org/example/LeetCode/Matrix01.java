package org.example.LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Matrix01 {
    static class Solution {
        private void addIndex(int[][] rooms, Queue<Integer> queue, Set<Integer> visitedSet, int m, int n, int i, int j) {
            int index = (i * n) + j;
            if (visitedSet.contains(index) || i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] != 1) return;

            queue.add(index);
            visitedSet.add(index);
        }

        public int[][] updateMatrix(int[][] mat) {
            int rows = mat.length;
            int cols = mat[0].length;

            Set<Integer> visitedSet = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            int count = 0;
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++){
                    if(mat[i][j] == 0) {
                        queue.add(count);
                        visitedSet.add(count);
                    }
                    count++;
                }
            }

            int distance = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int index = queue.remove();

                    int a = index / cols;
                    int b = index % cols;

                    addIndex(mat, queue, visitedSet, rows, cols, a - 1, b);
                    addIndex(mat, queue, visitedSet, rows, cols, a, b - 1);
                    addIndex(mat, queue, visitedSet, rows, cols, a + 1, b);
                    addIndex(mat, queue, visitedSet, rows, cols, a, b + 1);
                    mat[a][b] = distance;
                }
                distance++;
            }
            return mat;
        }
    }
}
