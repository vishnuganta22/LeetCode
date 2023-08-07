package org.example.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class WordBreak2 {
    static class Solution {
        private List<String> workBreakUtils(String s, List<String> wordDict, HashMap<String, List<String>> map){
            if(map.containsKey(s)) return map.get(s);
            if(s.equals("")) return new ArrayList<>(List.of(new String[]{""}));

            ArrayList<String> result = new ArrayList<>();
            for(String word : wordDict){
                if(s.indexOf(word) == 0){
                    String s1 = s.substring(word.length());
                    List<String> r = workBreakUtils(s1, wordDict, map);
                    r = r.stream().
                            map(data -> data.equals("") ? word :
                                    new StringBuilder(data).insert(0, word + " ").toString())
                            .collect(Collectors.toList());
                    result.addAll(r);
                }
            }
            map.put(s, result);
            return result;
        }

        public List<String> wordBreak(String s, List<String> wordDict) {
            return workBreakUtils(s, wordDict, new HashMap<>());
        }
    }

    public static void main(String[] args){
        String[] arr = new String[]{"cat","cats","and","sand","dog"};
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("catsanddog", Arrays.stream(arr).toList()));
    }
}
