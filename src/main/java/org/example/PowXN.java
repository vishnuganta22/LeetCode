package org.example;

import java.util.HashMap;
import java.util.Map;

public class PowXN {
    static class Solution {
        private double getRes(double x, int n){
            if (n == 0) return 1;
            if (n == 1) return x;
            int q = n / 2;
            double tem = getRes(x, q);
            double res = tem * tem;
            if (n % 2 == 1) res *= x;
            return res;
        }

        public double myPow(double x, int n) {
            if (n == 0) return 1;
            if (n < 0){
                int t = n + 1;
                double r = getRes(x, -1 * t);
                r *= x;
                return 1 / r;
            }
            return getRes(x, n);
        }
    }
}
