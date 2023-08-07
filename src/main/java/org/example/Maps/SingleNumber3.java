package org.example.Maps;

import java.util.HashMap;

public class SingleNumber3 {
    static class Solution {
        public int[] singleNumber(int[] nums) {
            int[] result = new int[2];

            HashMap<Integer, Integer> count = new HashMap<>();

            for (int num : nums) {
                if (count.containsKey(num)) {
                    int c = count.get(num);
                    c++;
                    count.put(num, c);
                } else {
                    count.put(num, 1);
                }
            }

            int i = 0;
            for(Integer k : count.keySet()){
                if(count.get(k) == 1){
                    result[i] = k;
                    i++;
                }
            }

            return result;
        }
    }
}
