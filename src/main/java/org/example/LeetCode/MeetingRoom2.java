package org.example.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    static class Solution {
        record Meeting(int start, int end) {}
        public int minMeetingRooms(int[][] intervals) {
            int result = 0;
            PriorityQueue<Meeting> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
            PriorityQueue<Integer> endQueue = new PriorityQueue<>();
            for (int i = 0; i < intervals.length; i++){
                queue.add(new Meeting(intervals[i][0], intervals[i][1]));
            }

            while (!queue.isEmpty()){
                Meeting meeting = queue.poll();
                if(result == 0){
                    endQueue.add(meeting.end);
                    result++;
                }else{
                    if(meeting.start < endQueue.peek()){
                        endQueue.add(meeting.end);
                        result++;
                    }else{
                        endQueue.poll();
                        endQueue.add(meeting.end);
                    }
                }
            }
            return result;
        }
    }
}
