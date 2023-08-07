package org.example.DynamicProgramming;

import java.util.HashMap;
import java.util.List;

public class WordBreak {
    static class Solution {

        public boolean wordBreak(String s, List<String> wordDict) {
            return workBreakUtils(s, new HashMap<String, Boolean>(), wordDict);
        }

        private boolean workBreakUtils(String s, HashMap<String, Boolean> map, List<String> wordDict) {
            if (map.containsKey(s)) return map.get(s);
            if (s.equals("")) return true;

            for (String word : wordDict) {
                if (s.indexOf(word) == 0) {
                    String s1 = s.substring(word.length());
                    boolean result = workBreakUtils(s1, map, wordDict);
                    map.put(s, result);
                    if (result) return true;
                }
            }
            map.put(s, false);
            return false;
        }
    }
}
