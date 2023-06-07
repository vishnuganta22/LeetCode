package org.example.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            ArrayList<Integer> result = new ArrayList<>();
            //System.out.println("M :: " + m);
            //System.out.println("N :: " + n);

            int rs = 0, cs = 0, re = matrix.length - 1, ce = matrix[0].length - 1;
            while(rs <= re && cs <= ce){
                //System.out.println("RS :: " + rs);
                //System.out.println("RE :: " + re);
                //System.out.println("CS :: " + cs);
                //System.out.println("CE :: " + ce);
                int i = rs, j = cs;
                if(rs == re){
                    while(j <= ce){
                        //System.out.println("CASE Single Row :: " + matrix[i][j]);
                        //System.out.println("I :: " + i);
                        //System.out.println("J :: " + j);
                        result.add(matrix[i][j]);
                        j++;
                    }
                    rs++;
                    continue;
                }
                if(cs == ce){
                    while(i <= re){
                        //System.out.println("CASE Single Column :: " + matrix[i][j]);
                        //System.out.println("I :: " + i);
                        //System.out.println("J :: " + j);
                        result.add(matrix[i][j]);
                        i++;
                    }
                    cs++;
                    continue;
                }
                while(j < ce){
                    //System.out.println("CASE 1 :: " + matrix[i][j]);
                    //System.out.println("I :: " + i);
                    //System.out.println("J :: " + j);
                    result.add(matrix[i][j]);
                    j++;
                }
                //result.add(matrix[i][j]);
                while(i < re){
                    //System.out.println("CASE 2 :: " + matrix[i][j]);
                    //System.out.println("I :: " + i);
                    //System.out.println("J :: " + j);
                    result.add(matrix[i][j]);
                    i++;
                }
                while(j > cs){
                    //System.out.println("CASE 3 :: " + matrix[i][j]);
                    //System.out.println("I :: " + i);
                    //System.out.println("J :: " + j);
                    result.add(matrix[i][j]);
                    j--;
                }
                while(i > rs){
                    //System.out.println("CASE 4 :: " + matrix[i][j]);
                    //System.out.println("I :: " + i);
                    //System.out.println("J :: " + j);
                    result.add(matrix[i][j]);
                    i--;
                }
                rs++;
                cs++;
                re--;
                ce--;
            }
            return result;
        }
    }
}
