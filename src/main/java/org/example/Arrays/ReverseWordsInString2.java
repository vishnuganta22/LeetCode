package org.example.Arrays;

public class ReverseWordsInString2 {
    static class Solution {
        public void reverseWords(char[] s) {
            int i = 0;
            int j = s.length - 1;

            while (i < j){
                char c = s[i];
                s[i] = s[j];
                s[j] = c;
                i++;
                j--;
            }

            int ws = 0, we = 0;
            boolean isWordStarted = false;
            for (i = 0; i < s.length; i++){
                if(s[i] == ' '){
                    if(isWordStarted){
                        we = i - 1;
                    }
                    isWordStarted = false;
                }else{
                    if(!isWordStarted){
                        ws = i;
                    }else{
                        if(i == s.length - 1) we = i;
                    }
                    isWordStarted = true;
                }

                while (we > ws){
                    char c = s[ws];
                    s[ws] = s[we];
                    s[we] = c;
                    ws++;
                    we--;
                }
            }
        }
    }
}
