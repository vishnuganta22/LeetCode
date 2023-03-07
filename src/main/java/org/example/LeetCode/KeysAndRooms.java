package org.example.LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {
    static class Solution {

        private void DFSUtils(List<Integer> keys, Set<Integer> nodeVisited, Integer node, List<List<Integer>> rooms) {
            if (nodeVisited.contains(node)) return;

            nodeVisited.add(node);

            for (Integer i : keys) {
                if (!nodeVisited.contains(i)) {
                    DFSUtils(rooms.get(i), nodeVisited, i, rooms);
                }
            }
        }

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int count = rooms.size();
            Set<Integer> visitedNodes = new HashSet<>();

            int i = 0;
            DFSUtils(rooms.get(i), visitedNodes, i, rooms);
            return visitedNodes.size() == count;
        }
    }
}
