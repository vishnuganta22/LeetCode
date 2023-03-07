package org.example.LeetCode;

public class PostToBinary {
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
        private TreeNode buildTreeUtils(int[] inorder, int[] postorder, int iStart, int iEnd, int pStart, int pEnd){
            if(pStart > pEnd) return null;
            if(iStart > iEnd) return null;
            TreeNode node = new TreeNode(postorder[pEnd]);
            for (int i = iStart; i <= iEnd; i++){
                if(postorder[pEnd] == inorder[i]){
                    node.left = buildTreeUtils(inorder, postorder,  iStart, i - 1, pStart, (pEnd- (iEnd - i) -1));
                    node.right = buildTreeUtils(inorder, postorder, i + 1, iEnd, pEnd- (iEnd - i), pEnd-1);
                    break;
                }
            }
            return node;
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTreeUtils(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
        }
    }
}
