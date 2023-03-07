package org.example.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BinaryTreeLCA {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    static class Solution {
        record Result(TreeNode node, Set<Integer> set){}

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return lowestCommonAncestorUtils(root, p, q).node;
        }

        private Result lowestCommonAncestorUtils(TreeNode node, TreeNode p, TreeNode q){
            if(node == null) return new Result(null, new HashSet<>());

            Result leftR = lowestCommonAncestorUtils(node.left, p, q);
            Result rightR = lowestCommonAncestorUtils(node.right, p, q);

            if(leftR.set.size() == 2) return leftR;
            if(rightR.set.size() == 2) return rightR;

            HashSet<Integer> set = new HashSet<>();
            set.addAll(leftR.set);
            set.addAll(rightR.set);
            if(set.size() == 2) return new Result(node, set);
            if(node.val == p.val || node.val == q.val) set.add(node.val);
            if(set.size() == 2) return new Result(node, set);
            else return new Result(null, set);
        }
    }
}
