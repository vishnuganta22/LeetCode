package org.example;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    static class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> tMap = new HashMap<>();
            for (int i = 0; i < t.length(); i++){
                int c = tMap.getOrDefault(t.charAt(i), 0);
                tMap.put(t.charAt(i), c + 1);
            }

            int left = 0;
            int right = 0;
            int size = -1;
            int fLeft = 0;
            int fRight = 0;
            int foundCount = 0;
            Map<Character, Integer> wMap = new HashMap<>();
            while (right < s.length()){
                Character c = s.charAt(right);
                int count = wMap.getOrDefault(c, 0);
                wMap.put(c, count + 1);
                if(tMap.containsKey(c) && tMap.get(c).intValue() == wMap.get(c).intValue()){
                    foundCount++;
                }

                while (left <= right && foundCount == tMap.size()){
                    c = s.charAt(left);
                    if(size == -1 || (right - left + 1) < size){
                        size = (right - left + 1);
                        fLeft = left;
                        fRight = right;
                    }

                    wMap.put(c, wMap.get(c)- 1);
                    if(tMap.containsKey(c) && wMap.get(c).compareTo(tMap.get(c)) < 0){
                        foundCount--;
                    }

                    left++;
                }
                right++;
            }
            return size == -1 ? "" : s.substring(fLeft, fRight + 1);
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.minWindow("ADOBECODEBANC", "ABC");
    }
}
