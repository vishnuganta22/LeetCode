package org.example.Arrays;

public class AddBinary {
    static class Solution {
        public String addBinary(String a, String b) {
            char[] l, s;
            if(a.length() > b.length()){
                l = a.toCharArray();
                s = b.toCharArray();
            }else{
                l = b.toCharArray();
                s = a.toCharArray();
            }

            StringBuilder result = new StringBuilder();
            boolean isCarry = false;
            int diff = l.length - s.length;
            for (int i = s.length - 1; i >= 0; i--){
                if(l[i + diff] == '1' && s[i] == '1'){
                    if(isCarry){
                        result.append('1');
                    }else{
                        result.append('0');
                    }
                    isCarry = true;
                }else if(l[i + diff] == '0' && s[i] == '0'){
                    if(isCarry){
                        result.append('1');
                    }else{
                        result.append('0');
                    }
                    isCarry = false;
                }else{
                    if(isCarry){
                        result.append('0');
                    }else{
                        result.append('1');
                    }

                }
            }

            if(diff > 0){
                int i = diff - 1;
                while (i >= 0){
                    if (l[i] == '1'){
                        if (isCarry){
                            result.append('0');
                        }else{
                            result.append('1');
                        }
                    }else{
                        if (isCarry){
                            result.append('1');
                            isCarry = false;
                        }else{
                            result.append('0');
                        }
                    }
                    i--;
                }
            }

            if(isCarry) result.append('1');

            return result.reverse().toString();
        }
    }
}
