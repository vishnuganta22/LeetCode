package org.example.LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KWeakestRowsInMatrix {
    static class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            HashMap<Integer, Integer> sCount = new HashMap<>();
            for (int i = 0; i < mat.length; i++){
                sCount.put(i, 0);
                for (int j = 0; j < mat[i].length; j++){
                    if(mat[i][j] == 1){
                        int c = sCount.get(i);
                        c++;
                        sCount.put(i, c);
                    }else{
                        break;
                    }
                }
            }

            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
                if(o1.getValue().equals(o2.getValue())){
                    if(o1.getKey() < o2.getKey()){
                        return -1;
                    }else{
                        return 1;
                    }
                }else if(o1.getValue() > o2.getValue()){
                    return 1;
                }else{
                    return -1;
                }
            });

            queue.addAll(sCount.entrySet());

            int[] result = new int[k];
            for (int i = 0; i < k; i++){
                Map.Entry<Integer, Integer> entry = queue.poll();
                if(entry != null){
                    result[i] = entry.getKey();
                }else{
                    result[i] = -1;
                }
            }
            return result;
        }
    }
}
