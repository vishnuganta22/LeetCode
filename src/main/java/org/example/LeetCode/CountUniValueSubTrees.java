package org.example.LeetCode;

public class CountUniValueSubTrees {
    static public class TreeNode {
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

    static class Solution {
        record Result(int count, boolean isUniValSubTree){}

        private boolean isLeaf(TreeNode node){
            return node.left == null && node.right == null;
        }

        private Result countUniValSub(TreeNode node){
            if(node == null) return new Result(0, true);
            if(isLeaf(node)) return new Result(1, true);

            Result leftResult = countUniValSub(node.left);
            Result rightResult = countUniValSub(node.right);
            boolean isUniValSubTree = (leftResult.isUniValSubTree && rightResult.isUniValSubTree &&
                    (node.left == null || node.val == node.left.val) &&
                    (node.right == null || node.val == node.right.val));
            int count = isUniValSubTree ? 1 + leftResult.count + rightResult.count : leftResult.count + rightResult.count;
            return new Result(count, isUniValSubTree);
        }

        public int countUnivalSubtrees(TreeNode root) {
            return countUniValSub(root).count;
        }
    }
}
