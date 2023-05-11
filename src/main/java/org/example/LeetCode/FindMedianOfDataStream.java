package org.example.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianOfDataStream {
    static class MedianFinder {
        private final PriorityQueue<Integer> smallHeap;
        private final PriorityQueue<Integer> largeHeap;
        public MedianFinder() {
            this.smallHeap = new PriorityQueue<>(Comparator.reverseOrder());
            this.largeHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            this.smallHeap.add(num);

            while (this.smallHeap.size() > 0 && this.largeHeap.size() > 0
                && this.smallHeap.peek() > this.largeHeap.peek()){
                this.largeHeap.add(this.smallHeap.poll());
            }

            while (this.smallHeap.size() - this.largeHeap.size() > 1 ||
                    this.largeHeap.size() - this.smallHeap.size() > 1){
                if(this.smallHeap.size() - this.largeHeap.size() > 1){
                    this.largeHeap.add(this.smallHeap.poll());
                }else{
                    this.smallHeap.add(this.largeHeap.poll());
                }
            }
        }

        public double findMedian() {
            if (smallHeap.size() == largeHeap.size()){
                int small = smallHeap.peek();
                int large = largeHeap.peek();;
                return (double) (small + large) / 2;
            }else{
                if(smallHeap.size() > largeHeap.size()) return (double) smallHeap.peek();
                else return (double) largeHeap.peek();
            }
        }
    }
}
