package org.example;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Solution {
        private int getCount(int n, Map<Integer, Integer> map){
            if(map.containsKey(n)) return map.get(n);
            int result = 0;
            for (int i = 1; i <= n; i++){
                result += (getCount(i - 1, map) * getCount(n - i, map));
            }
            map.put(n, result);
            return result;
        }

        public int numTrees(int n) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            map.put(1, 1);
            map.put(2, 2);
            return getCount(n,map);
        }
    }
}
