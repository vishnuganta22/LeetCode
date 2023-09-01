package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Tiktok {
    public static void main(String[] args){
        int[] arr = new int[]{3, 1, 2};
        int x = 5;
        int y = 7;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < arr.length; i++){
            queue.add(arr[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            list.add(queue.poll());
        }

        int result = 0;
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }

        if(x <= list.size()){
            int i = 0;
            int ix = 0;
            while(i < y){
                if(ix == x) ix = 0;
                result += list.get(ix);
                ix++;
                i++;
            }
        }else{
            int q = y / x;
            int r = y % x;

            result += (q * sum);

            if(list.size() <= r){
                result += sum;
            }else{
                int i = 0;
                while (r > 0){
                    result += list.get(i);
                    r--;
                    i++;
                }
            }
        }
        System.out.println(result);
    }
}
