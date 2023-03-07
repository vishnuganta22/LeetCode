package org.example.LeetCode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerDeSerBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder builder = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            builder.append(root.val);
            int counter = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++){
                    TreeNode node = queue.remove();
                    if(node.left != null) {
                        queue.add(node.left);
                        addData(builder, node.left, counter);
                        counter = 0;
                    }else {
                        counter++;
                    }

                    if(node.right != null) {
                        queue.add(node.right);
                        addData(builder, node.right, counter);
                        counter = 0;
                    }else {
                        counter++;
                    }
                }
            }
            return builder.toString();
        }

        private void addData(StringBuilder builder, TreeNode node, int counter){
            for(int i = 0; i < counter;i++){
                builder.append(',');
                builder.append('N');
            }
            builder.append(',');
            builder.append(node.val);
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.isEmpty()) return null;
            String[] split = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(split[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int counter = 0;
            while (!queue.isEmpty() && counter < split.length){
                int size = queue.size();
                for (int i = 0; i < size; i++){
                    TreeNode node = queue.remove();
                    if(counter+1 >= split.length || Objects.equals(split[counter+1], "N")){
                        node.left = null;
                    }else {
                        node.left = new TreeNode(Integer.parseInt(split[counter+1]));
                        queue.add(node.left);
                    }

                    if(counter+2 >= split.length || Objects.equals(split[counter+2], "N")){
                        node.right = null;
                    }else {
                        node.right = new TreeNode(Integer.parseInt(split[counter+2]));
                        queue.add(node.right);
                    }
                    counter = counter+2;
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(null));
    }
}
