package org.example.Arrays;

public class ReverseWordsInString3 {
    static class Solution {
        public String reverseWords(String s) {
            String[] arr = s.split(" ");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < arr.length; i++){
                char[] sArr = arr[i].toCharArray();
                int p = 0;
                int q = sArr.length - 1;
                while (p < q){
                    char c = sArr[p];
                    sArr[p] = sArr[q];
                    sArr[q] = c;
                    p++;
                    q--;
                }
                builder.append(sArr);
                if(i != arr.length - 1) builder.append(" ");
            }
            return builder.toString();
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }
}
