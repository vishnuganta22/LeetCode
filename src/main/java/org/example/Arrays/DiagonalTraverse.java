package org.example.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DiagonalTraverse {
    static class Solution {
        public int[] findDiagonalOrder(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            int t = (m - 1) + (n - 1);

            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(!map.containsKey(i + j)){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(mat[i][j]);
                        map.put(i+j, list);
                    }else{
                        map.get(i+j).add(mat[i][j]);
                    }
                }
            }

            int[] result = new int[m * n];
            boolean s = false;
            int k = 0;
            for(int i = 0; i <= t; i++){
                ArrayList<Integer> list = map.get(i);
                if(s){
                    for(Integer j : list){
                        result[k] = j;
                        k++;
                    }
                }else{
                    for(int j = list.size() - 1; j >=0; j--){
                        result[k] = list.get(j);
                        k++;
                    }
                }
                s = !s;
            }
            return result;
        }
    }
}
