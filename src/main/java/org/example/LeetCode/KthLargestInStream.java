package org.example.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestInStream {
    static class KthLargest {
        private final PriorityQueue<Integer> queue;
        private final int k;
        public KthLargest(int k, int[] nums) {
            this.queue = new PriorityQueue<>(k);
            this.k = k;
            for (int i = 0; i < nums.length; i++){
                //System.out.println("Queue Size :: " + this.queue.size());
                //System.out.println("K Value :: " + this.k);
                if(this.queue.size() >= this.k){
                    if(nums[i] >= this.queue.peek()){
                        //System.out.println("Peek :: " + this.queue.peek());
                        //System.out.println("Adding :: " + nums[i]);
                        this.queue.poll();
                        this.queue.add(nums[i]);
                    }
                }else{
                    //System.out.println("Adding :: " + nums[i]);
                    this.queue.add(nums[i]);
                }
            }
        }

        public int add(int val) {
            //System.out.println("Queue Size :: " + this.queue.size());
            //System.out.println("K Value :: " + this.k);
            if(this.queue.size() >= this.k){
                if(val >= this.queue.peek()){
                    //System.out.println("Peek :: " + this.queue.peek());
                    //System.out.println("Adding :: " +val);
                    this.queue.poll();
                    this.queue.add(val);
                }
            }else{
                //System.out.println("Adding :: " + val);
                this.queue.add(val);
            }
            return this.queue.peek();
        }
    }
}
