package org.example.Maps;

public class SingleNumber2 {
    static class Solution {

        public static void singleNumber() {
            int t = 321;
            int result = 0;
            do{
                int p = t % 10;
                result = result * 10 + p;
                t = t / 10;
            }while(t > 0);
            System.out.println(result);
        }
    }

    public static void main(String[] args){
        Solution.singleNumber();
    }
}
