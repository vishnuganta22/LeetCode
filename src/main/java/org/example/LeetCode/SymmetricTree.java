package org.example.LeetCode;

import java.util.*;

public class SymmetricTree {
    static class TreeNode {
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
        private boolean isMirror(TreeNode left, TreeNode right) {
            if ((left == null && right != null) || (left != null && right == null)) return false;
            if (left == null && right == null) return true;
            return (left.val == right.val) && isMirror(left.right, right.left) && isMirror(left.left, right.right);
        }

        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return isMirror(root.left, root.right);
        }

        private boolean isLeaf(TreeNode node) {
            return (node == null) || (node.left == null && node.right == null);
        }

        //produces memory limit exceeded
        public boolean isSymmetricUtils(TreeNode root) {
            boolean isSymmetric = true;
            if (isLeaf(root)) return true;

            if ((root.left == null && root.right != null) || (root.left != null && root.right == null) || (root.left.val != root.right.val)) return false;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root.left);
            queue.add(root.right);

            while (!queue.isEmpty()) {
                ArrayList<TreeNode> list = new ArrayList<>();
                int size = queue.size();
                boolean isAllNulls = true;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.remove();
                    if (node != null) {
                        isAllNulls = false;
                        queue.add(node.left);
                        queue.add(node.right);
                    } else {
                        queue.add(null);
                        queue.add(null);
                    }
                    list.add(node);
                }

                if (isAllNulls) break;
                if (!isSymmetric) break;
                int count = list.size();
                for (int i = 0; i < count / 2; i++) {
                    TreeNode left = list.get(i);
                    TreeNode right = list.get(count - i - 1);

                    if ((left == null && right != null) || (left != null && right == null)) return false;
                    if (left == null && right == null) continue;

                    isSymmetric = isSymmetric && (left.val == right.val);
                }
            }

            return isSymmetric;
        }

        record TreeNodePosition(long pos, TreeNode node, long size) {}

        private boolean isSymmetricIterative(TreeNode root){
            boolean isSymmetric = true;
            if(root == null || (root.left == null && root.right == null)) return true;

            if ((root.left == null && root.right != null) || (root.left != null && root.right == null) || (root.left.val != root.right.val)) return false;

            Queue<TreeNodePosition> queue = new LinkedList<>();
            queue.add(new TreeNodePosition(1, root.left, 2));
            queue.add(new TreeNodePosition(2, root.right, 2));

            while (!queue.isEmpty()){
                int size = queue.size();
                HashMap<Long, TreeNodePosition> map = new HashMap<>();
                for(int i = 0; i < size; i++){
                    TreeNodePosition nodePosition = queue.remove();
                    if(nodePosition.node.left != null) queue.add(new TreeNodePosition((2 * nodePosition.pos) - 1, nodePosition.node.left, 2 * nodePosition.size));
                    if(nodePosition.node.right != null) queue.add(new TreeNodePosition((2 * nodePosition.pos), nodePosition.node.right, 2 * nodePosition.size));
                    map.put(nodePosition.pos, nodePosition);
                }

                for (Map.Entry<Long, TreeNodePosition> entry : map.entrySet()) {
                    long key = entry.getKey();
                    TreeNodePosition val = entry.getValue();
                    long tempKey = val.size - key + 1;

                    if(!map.containsKey(tempKey)) return false;
                    if (map.get(tempKey).node.val != val.node.val) return false;
                }
            }

            return isSymmetric;
        }
    }
}
