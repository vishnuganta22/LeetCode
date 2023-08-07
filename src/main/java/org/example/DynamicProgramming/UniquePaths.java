package org.example.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
    static class Solution {
        private int uniquePathUtils(int m, int n, Map<String, Integer> map) {
            String key = m + "," + n;
            String rKey = n + "," + m;
            if (map.containsKey(key)) return map.get(key);
            if (map.containsKey(rKey)) return map.get(rKey);
            if (m == 0 || n == 0) return 0;
            if (m == 1 && n == 1) return 1;

            int result = uniquePathUtils(m - 1, n, map) + uniquePathUtils(m, n - 1, map);
            map.put(key, result);
            map.put(rKey, result);
            return result;
        }

        public int uniquePaths(int m, int n) {
            return uniquePathUtils(m, n, new HashMap<>());
        }
    }
}
