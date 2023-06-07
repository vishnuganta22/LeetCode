package org.example.Arrays;

import java.util.Arrays;

public class ValidMountainArray {
    class Solution {
        public boolean validMountainArray(int[] arr) {
            if(arr.length < 3) return false;

            boolean in = true;
            boolean isIncreased = false;
            for (int i = 1; i < arr.length; i++){
                if(in){
                    if(arr[i] == arr[i - 1]) return false;
                    else if(arr[i] < arr[i - 1]) in = false;
                    else isIncreased = true;
                }else{
                    if(arr[i] == arr[i - 1]) return false;
                    else if(arr[i] > arr[i - 1]) return false;
                }
            }
            if(!isIncreased) return false;
            return !in;
        }
    }
}
