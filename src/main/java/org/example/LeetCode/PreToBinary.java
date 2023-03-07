package org.example.LeetCode;

public class PreToBinary {
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

    class Solution {
        private TreeNode buildTreeUtils(int[] inOrder, int[] preOrder, int iStart, int iEnd, int pStart, int pEnd){
            if(iStart > iEnd) return null;
            if(pStart > pEnd) return null;
            TreeNode node = new TreeNode(preOrder[pStart]);
            for (int i = iStart; i <= iEnd; i++){
                if(inOrder[i] == preOrder[pStart]){
                    node.left = buildTreeUtils(inOrder, preOrder, iStart, i-1, pStart+1, pStart+(i-iStart));
                    node.right = buildTreeUtils(inOrder, preOrder, i+1, iEnd, pStart+(i-iStart)+1, pEnd);
                    break;
                }
            }
            return node;
        }
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTreeUtils(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);
        }
    }
}
