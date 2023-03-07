package org.example;

public class SearchInBST {
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

        private TreeNode searchBSTUtils(TreeNode root, int val){
            if(root == null) return null;
            if(root.val == val) return root;
            if (val < root.val) return searchBSTUtils(root.left, val);
            return searchBSTUtils(root.right, val);
        }

        public TreeNode searchBST(TreeNode root, int val) {
            return searchBSTUtils(root, val);
        }
    }
}
