package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Robot {
    private static int matrixSolution(Set<Integer> set, int[][] matrix, int x, int y, int r, int c, int dx, int dy, int amount){
        int index = (x * c) + y;
        if(set.contains(index)) return amount;
        if(x < 0 || y < 0) return amount;
        if(x == 0 && y == 0) return amount;

        set.add(index);
        amount += matrix[x][y];

        int tempx = x + dx;
        int tempy = y + dy;

        if(tempx >= r) {
            dx = -1;
            tempx = x + dx;
        }else if(tempx < 0){
            dx = 1;
            tempx = x + dx;
        }

        if(tempy >= c){
            dy = -1;
            tempy = y + dy;
        }else if(tempy < 0){
            dy = 1;
            tempy = y + dy;
        }
        return matrixSolution(set, matrix, tempx, tempy, r, c, dx, dy, amount);
    }

    public static int solution(int[][] matrix, int x, int y){
        int row = matrix.length;
        int col = matrix[0].length;
        return matrixSolution(new HashSet<>(), matrix, x, y, row, col, 1, 1, 0);
    }

    public static void main(String[] args){
        int[][] matrx = {{-12, 33, -4}, {12, -1, 15}, {49, -4, 10}};
        int[][] matrix2 = {{0, -2, 8, -4}, {1, 4, 3, 5}, {2, 4, -2, 6}, {1, 4, -4, 7}};
        int[][] matrix3 = {{-28, -30, -9}, {2, -34, -20}, {16, -12, 30}, {14, 27, -4}, {8, -10, 32}, {-26, 18, 27}, {2, 34, 4}, {-34, 27, -14}, {-30, 31, 25}, {21, -17, -9}, {-16, -25, -15}, {16, 6, 4}, {9, 27, 37}, {-26, 18, -27}
        , {}};
        System.out.println(solution(matrx, 0, 1));
        System.out.println(solution(matrix2, 2, 0));
    }
}
