package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    class Solution {

        private void generateUtils(int numRows, List<List<Integer>> result){
            if (numRows <= 0) {
                result.add(new ArrayList<>(List.of(1)));
                return;
            }
            if (numRows == 1) {
                generateUtils(numRows - 1, result);
                result.add(new ArrayList<>(Arrays.asList(1, 1)));
                return;
            }
            generateUtils(numRows - 1, result);
            ArrayList<Integer> list = new ArrayList<>();
            List<Integer> previous = result.get(numRows - 1);
            list.add(1);
            for(int i = 1; i < numRows; i++){
                list.add(previous.get(i - 1) + previous.get(i));
            }
            list.add(1);
            result.add(list);
        }

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            generateUtils(numRows - 1, result);
            return result;
        }
    }
}
