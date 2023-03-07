package org.example.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangle2 {
    class Solution {
        private int getData(int row, int col, Map<String, Integer> map){
            if (row == 0 || row == 1) return 1;
            if (col == 0 || col == row) return 1;
            if (col == 1 || col == row - 1) return row;
            String rKey = row + String.valueOf(col);
            if (map.containsKey(rKey)) return map.get(rKey);
            String k = String.valueOf(row - col);
            if(map.containsKey(row + k)) return map.get(row+k);
            int result = getData(row - 1, col - 1, map) + getData(row - 1, col, map);
            map.put(rKey, result);
            return result;
        }

        public List<Integer> getRow(int rowIndex) {
            HashMap<String, Integer> map = new HashMap<>();
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i <= rowIndex; i++){
                result.add(getData(rowIndex, i, map));
            }
            return result;
        }
    }
}
