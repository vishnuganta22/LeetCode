package org.example.LeetCode;

public class MaxDepthOfBT {

     // Definition for a binary tree node.
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    static class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null) return 0;
            if(root.left == null && root.right == null) return 1;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
