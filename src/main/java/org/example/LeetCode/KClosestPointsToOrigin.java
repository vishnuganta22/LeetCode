package org.example.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    static class Solution {
        record Point(int x, int y, double distance){}

        private double getDistance(int x, int y){
            return Math.sqrt((x*x) + (y*y));
        }
        public int[][] kClosest(int[][] points, int k) {
            int[][] result = new int[k][2];
            PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> o.distance));
            for (int i = 0; i < points.length; i++){
                queue.add(new Point(points[i][0], points[i][1], getDistance(points[i][0], points[i][1])));
            }

            for (int i = 0; i < k; i++){
                Point point = queue.poll();
                result[i][0] = point.x();
                result[i][1] = point.y();
            }
            return result;
        }
    }
}
