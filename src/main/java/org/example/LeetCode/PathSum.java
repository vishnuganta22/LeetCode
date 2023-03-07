package org.example.LeetCode;

public class PathSum {

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
        private boolean isLeaf(TreeNode node){
            return (node == null) || (node.left == null && node.right == null);
        }
        private boolean hasPath(TreeNode node, int targetSum){
            if(node == null) return false;
            if(isLeaf(node) && targetSum - node.val != 0) return false;
            if(isLeaf(node) && targetSum - node.val == 0) return true;
            return hasPath(node.left, targetSum - node.val) || hasPath(node.right, targetSum - node.val);
        }

        public boolean hasPathSum(TreeNode root, int targetSum) {
            return hasPath(root, targetSum);
        }
    }
}
