package org.example.Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class DuplicateZeros {
    class Solution {
        public void duplicateZeros(int[] arr) {
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < arr.length; i++){
                queue.add(arr[i]);
            }

            for (int i = 0; i < arr.length; i++){
                if(queue.peek() == 0){
                    arr[i] = queue.poll();
                    i++;
                    if(i < arr.length)arr[i] = 0;
                }else{
                    arr[i] = queue.poll();
                }
            }
        }
    }
}
