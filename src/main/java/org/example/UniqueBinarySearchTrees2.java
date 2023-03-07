package org.example;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
    public class TreeNode {
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
        public List<TreeNode> generate(int start, int end) {
            ArrayList<TreeNode> all_trees = new ArrayList<>();
            if (start > end) {
                all_trees.add(null);
                return all_trees;
            }

            // pick up a root
            for (int i = start; i <= end; i++) {
                // all possible left subtrees if i is choosen to be a root
                List<TreeNode> left_trees = generate(start, i - 1);

                // all possible right subtrees if i is choosen to be a root
                List<TreeNode> right_trees = generate(i + 1, end);

                // connect left and right trees to the root i
                for (TreeNode l : left_trees) {
                    for (TreeNode r : right_trees) {
                        TreeNode current_tree = new TreeNode(i);
                        current_tree.left = l;
                        current_tree.right = r;
                        all_trees.add(current_tree);
                    }
                }
            }
            return all_trees;
        }

        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new ArrayList<TreeNode>();
            return generate(1, n);
        }
    }
}
