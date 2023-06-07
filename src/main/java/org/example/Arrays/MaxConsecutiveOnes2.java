package org.example.Arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class MaxConsecutiveOnes2 {
    static class Solution {
        public int findMaxConsecutiveOnesV2(int[] nums){
            int result = 0;
            int c = 0;
            int p = -1;
            int pc = 0;
            int zc = 0;
            for (int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    zc++;
                    if(p == -1){
                        result = c;
                    }else if(i - p == 1){

                    }else{
                        int r = pc + c;
                        if(r > result) result = r;
                    }
                    p = i;
                    pc = c;
                    c = 0;
                }else{
                    c++;
                }
            }

            if(zc == 1 || zc == 0) return nums.length;
            if(zc == nums.length) return 1;

            if(nums[nums.length - 1] != 0){
                int r = pc + c;
                if(r > result) result = r;
            }

            return result + 1;
        }
        public int findMaxConsecutiveOnes(int[] nums) {
            int c = 0;
            int i;
            LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
            for(i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    map.put(i, c);
                    c = 0;
                }else{
                    c++;
                }
            }

            System.out.println("Positions :: " + map.keySet());
            System.out.println("Counts :: " + map.values());

            if(map.size() == 1 || map.size() == 0){
                return nums.length;
            }

            if(map.size() == nums.length){
                return 1;
            }


            if(!map.containsKey(i - 1)){
                map.put(nums.length - 1, c);
            }

            int result = 0;
            int p = -1;
            int index = 0;

            for (Map.Entry<Integer, Integer> entry: map.entrySet()){
                if(p == -1){
                    result = entry.getValue();
                }else if((entry.getKey() - p) == 1){
                    // ignore
                }else{
                    int r = index + entry.getValue();
                    if(r > result) result = r;
                }
                p = entry.getKey();
                index = entry.getValue();
            }
            return result + 1;
        }
    }
}
