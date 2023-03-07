package org.example.LeetCode;

import java.util.*;

public class OpenTheLock {
    class Solution {
        private void addPoint(String point, Queue<String> queue, Set<String> visitedSet){
            if(visitedSet.contains(point)){
                return;
            }
            queue.add(point);
            visitedSet.add(point);
        }
        private String getNextPoint(String point, int pos, boolean isForward){
            if(point.length() < 4 || pos > 3) throw new RuntimeException("Invalid Point or Position");
            char item = point.charAt(pos);
            StringBuilder result = new StringBuilder(point);
            switch (item) {
                case '1' -> result.setCharAt(pos, isForward ? '2' : '0');
                case '2' -> result.setCharAt(pos, isForward ? '3' : '1');
                case '3' -> result.setCharAt(pos, isForward ? '4' : '2');
                case '4' -> result.setCharAt(pos, isForward ? '5' : '3');
                case '5' -> result.setCharAt(pos, isForward ? '6' : '4');
                case '6' -> result.setCharAt(pos, isForward ? '7' : '5');
                case '7' -> result.setCharAt(pos, isForward ? '8' : '6');
                case '8' -> result.setCharAt(pos, isForward ? '9' : '7');
                case '9' -> result.setCharAt(pos, isForward ? '0' : '8');
                default -> result.setCharAt(pos, isForward ? '1' : '9');
            }
            return result.toString();
        }
        public int openLock(String[] deadends, String target) {
            if(Arrays.asList(deadends).contains("0000")) return -1;

            Queue<String> queue = new LinkedList<>();
            Set<String> visitedSet = new HashSet<>();
            queue.add("0000");
            visitedSet.add("0000");
            visitedSet.addAll(Arrays.asList(deadends));

            int distance = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++){
                    String point = queue.remove();
                    if (target.equals(point)) return distance;
                    addPoint(getNextPoint(point, 0, true), queue, visitedSet);
                    addPoint(getNextPoint(point, 0, false), queue, visitedSet);
                    addPoint(getNextPoint(point, 1, true), queue, visitedSet);
                    addPoint(getNextPoint(point, 1, false), queue, visitedSet);
                    addPoint(getNextPoint(point, 2, true), queue, visitedSet);
                    addPoint(getNextPoint(point, 2, false), queue, visitedSet);
                    addPoint(getNextPoint(point, 3, true), queue, visitedSet);
                    addPoint(getNextPoint(point, 3, false), queue, visitedSet);
                }
                distance++;
            }
            return  -1;
        }
    }
}
