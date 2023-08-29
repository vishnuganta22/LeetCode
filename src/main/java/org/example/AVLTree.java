package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AVLTree {
    private Node root = null;

    public static class Node {
        public int data;
        public Node left, right;
        public int height;

        public Node(int data) {
            this.data = data;
            this.height = 0;
            this.left = this.right = null;
        }
    }

    public void insert(int x) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while (true) {
            if (temp.data == x) return;
            else if (x < temp.data) {
                if (temp.left != null) {
                    stack.push(temp);
                    temp = temp.left;
                } else {
                    temp.left = new Node(x);
                    break;
                }
            } else {
                if (temp.right != null) {
                    stack.push(temp);
                    temp = temp.right;
                } else {
                    temp.right = new Node(x);
                    break;
                }
            }
        }
        updateHeights(stack);
        applyRotations(stack);
    }

    private void updateHeights(Stack<Node> nodeStack) {
        for (Node node : nodeStack) {
            node.height = height(node);
        }
    }

    private void applyRotations(Stack<Node> nodeStack) {
        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();
            int bf = getBalance(node);

            if (bf > 1) {
                // left heavy
            }
            if (bf < -1) {
                // right heavy
            }
        }
    }

    public Node search(int x) {
        Node temp = root;
        while (temp != null) {
            if (temp.data == x) return temp;
            else if (x < temp.data) temp = temp.left;
            else temp = temp.right;
        }
        return null;
    }

    private int getBalanceFactor(Node node) {
        return height(node.left) - height(node.right);
    }

    private int getBalance(Node node) {
        int lHeight = node.left != null ? node.left.height : -1;
        int rHeight = node.right != null ? node.right.height : -1;
        return lHeight - rHeight;
    }

    private Node leftRotate(Node node) {
        Node nRight = node.right;
        if (nRight == null) throw new RuntimeException("No Right Child, Can't perform left rotation");
        node.right = nRight.left;
        nRight.left = node;

        node.height = height(node);
        nRight.height = height(nRight);
        return nRight;
    }

    private Node rightRotate(Node node) {
        Node nLeft = node.left;
        if (nLeft == null) throw new RuntimeException("No Left Child, Can't perform right rotation");
        node.left = nLeft.right;
        nLeft.right = node;

        node.height = height(node);
        nLeft.height = height(nLeft);
        return nLeft;
    }

    private int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Iterative way to calculate the height of the tree for the give Node.
    private int heightIterative(Node node) {
        if (node == null) return 0;

        int height = 0;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            LinkedList<Node> tempQueue = new LinkedList<>();
            while (queue.size() > 0) {
                Node temp = queue.pop();
                if (temp.left != null) tempQueue.add(temp.left);
                if (temp.right != null) tempQueue.add(temp.right);
            }
            queue = tempQueue;
            if (!queue.isEmpty()) height++;
        }
        return height;
    }

    public boolean delete(int x) {
        return false;
    }
}
