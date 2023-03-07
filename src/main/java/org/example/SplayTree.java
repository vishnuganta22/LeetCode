package org.example;

import java.util.LinkedList;

public class SplayTree {
    private Node root = null;

    /*private void rightRotate(Node node) {
        Node nParent = node.parent;
        if (nParent != null) {
            if (nParent.left != null && nParent.left.data == node.data) {
                nParent.left = node.left;
            } else if (nParent.right != null && nParent.right.data == node.data) {
                nParent.right = node.left;
            }
            node.parent = node.left;
            node.left = node.left.right;
        } else {
            Node nLeft = node.left;
            node.parent = nLeft;
            if (nLeft != null) {
                node.left = nLeft.right;
                nLeft.right = node;
                nLeft.parent = null;
            }
        }
    }*/

    private void rightRotate(Node node) {
        Node nLeft = node.left;
        Node temp = nLeft.right;
        Node nParent = node.parent;
        if (nParent != null) {
            if (nParent.right == node) nParent.right = nLeft;
            else nParent.left = nLeft;
        }
        if (temp != null) temp.parent = node;
        nLeft.parent = nParent;
        nLeft.right = node;

        node.parent = nLeft;
        node.left = temp;
    }

    /*private void leftRotate(Node node) {
        Node nParent = node.parent;

        if (nParent != null) {
            if(nParent.left != null && nParent.left.data == node.data){
                nParent.left = node.right;
            }else if (nParent.right != null && nParent.right.data == node.data){
                nParent.right = node.right;
            }
            node.parent = node.right;
            node.right = node.right.left;
        } else {
            Node nRight = node.right;
            node.parent = nRight;
            if (nRight != null) {
                node.right = nRight.left;
                nRight.left = node;
                nRight.parent = null;
            }
        }
    }*/

    public Node getRoot(){
        return root;
    }

    private void leftRotate(Node node) {
        Node nRight = node.right;
        Node temp = nRight.left;
        Node nParent = node.parent;
        if (nParent != null) {
            if (nParent.right == node) nParent.right = nRight;
            else nParent.left = nRight;
        }
        if (temp != null) temp.parent = node;
        nRight.parent = nParent;
        nRight.left = node;

        node.parent = nRight;
        node.right = temp;
    }

    private void splayTopDown(int x) {
        if (root == null) return;
        if (root.data == x) return;

        Node res = new Node(Integer.MIN_VALUE);
        Node mPart, lPart, rPart;
        lPart = rPart = res;
        Node temp = root;
        res.left = res.right = null;
        while (true) {
            if (x < temp.data) {
                if (temp.left == null) break;
                if (x < temp.left.data) {
                    mPart = temp.left;
                    temp.left = mPart.right;
                    mPart.right = temp;
                    temp = mPart;
                    if (temp.left == null) break;
                }
                rPart.left = temp;
                rPart = temp;
                temp = temp.left;
            } else if (x > temp.data) {
                if (temp.right == null) break;
                if (x > temp.right.data) {
                    mPart = temp.right;
                    temp.right = mPart.left;
                    mPart.left = temp;
                    temp = mPart;
                    if (temp.right == null) break;
                }
                lPart.right = temp;
                lPart = temp;
                temp = temp.right;
            } else {
                break;
            }
        }
        lPart.right = temp.left;
        rPart.left = temp.right;
        temp.left = res.right;
        temp.right = res.left;
        root = temp;
    }

    private void splay(Node node) {
        if (root == null) return;
        if (node == null || node.data == root.data) return;

        while (true) {
            Node parent = node.parent;

            if (parent == null) break;
            Node grandParent = node.parent.parent;
            if (grandParent == null) {
                if (parent.left != null && (parent.left.data == node.data)) {
                    rightRotate(parent);
                } else if (parent.right != null && (parent.right.data == node.data)) {
                    leftRotate(parent);
                }
                break;
            } else {
                if (grandParent.left != null && (grandParent.left.data == parent.data)) {
                    if (parent.left != null && (parent.left.data == node.data)) {
                        rightRotate(grandParent);
                        rightRotate(parent);
                    } else if (parent.right != null && (parent.right.data == node.data)) {
                        leftRotate(parent);
                        rightRotate(grandParent);
                    }
                } else if (grandParent.right != null && (grandParent.right.data == parent.data)) {
                    if (parent.left != null && (parent.left.data == node.data)) {
                        rightRotate(parent);
                        leftRotate(grandParent);
                    } else if (parent.right != null && (parent.right.data == node.data)) {
                        leftRotate(grandParent);
                        leftRotate(parent);
                    }
                }
            }
        }
        this.root = node;
        this.root.parent = null;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node temp = root;
        while (true) {
            if (temp.data == data) break;

            if (data < temp.data) {
                if (temp.left != null) temp = temp.left;
                else {
                    Node n = new Node(data);
                    n.parent = temp;
                    temp.left = n;
                    temp = n;
                    break;
                }
            } else {
                if (temp.right != null) temp = temp.right;
                else {
                    Node n = new Node(data);
                    n.parent = temp;
                    temp.right = n;
                    temp = n;
                    break;
                }
            }
        }
        splay(temp);
    }

    private void deleteOnlyIfLeaf(int data) {
        if (root == null) return;
        Node temp = root;
        while (true) {
            if (temp.data == data) break;

            if (data < temp.data) {
                if (temp.left != null) temp = temp.left;
                else break;
            } else {
                if (temp.right != null) temp = temp.right;
                else break;
            }
        }

        if (temp.data == data) {
            if (temp.left == null && temp.right == null) {
                if (temp.data == root.data) {
                    this.root = null;
                } else {
                    Node parent = temp.parent;
                    if (parent != null) {
                        if (parent.left != null && parent.left.data == temp.data) {
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                    }
                }
            }
        }
    }

    public boolean delete(int data) {
        if (root == null) return false;

        Node temp = root;
        while (true) {
            if (temp.data == data) break;

            if (data < temp.data) {
                if (temp.left != null) temp = temp.left;
                else break;
            } else {
                if (temp.right != null) temp = temp.right;
                else break;
            }
        }

        if (temp.data == data) {
            if (temp.left == null && temp.right == null) {
                if (temp.data == root.data) {
                    this.root = null;
                    temp = null;
                } else {
                    Node parent = temp.parent;
                    if (parent != null) {
                        if (parent.left != null && parent.left.data == temp.data) {
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                    }
                    temp = parent;
                }
            } else if (temp.left == null) {
                if (temp.data == root.data) {
                    this.root.data = temp.right.data;
                    this.root.left = temp.right.left;
                    this.root.right = temp.right.right;
                    temp = root;
                } else {
                    temp.data = temp.right.data;
                    temp.left = temp.right.left;
                    temp.right = temp.right.right;
                    temp = temp.parent;
                }
            } else if (temp.right == null) {
                if (temp.data == root.data) {
                    this.root.data = temp.left.data;
                    this.root.right = temp.left.right;
                    this.root.left = temp.left.left;
                    temp = root;
                } else {
                    temp.data = temp.left.data;
                    temp.right = temp.left.right;
                    temp.left = temp.left.left;
                    temp = temp.parent;
                }
            } else {
                Node node = minValue(temp.right);
                if (node.data == temp.right.data) {
                    temp.data = node.data;
                    temp.right = node.right;
                } else {
                    int minValue = node.data;
                    deleteOnlyIfLeaf(node.data);
                    temp.data = minValue;
                }
                temp = temp.parent;
            }
        }
        splay(temp);
        return true;
    }

    private Node minValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node search(int data) {
        if (root == null) return null;

        Node temp = root;
        while (true) {
            if (temp.data == data) break;

            if (data < temp.data) {
                if (temp.left != null) temp = temp.left;
                else break;
            } else {
                if (temp.right != null) temp = temp.right;
                else break;
            }
        }
        splay(temp);
        return temp.data == data ? temp : null;
    }

    private void preOrderTraversalUtils(Node node, String suffix) {
        if (node == null) return;
        System.out.print(node.data + suffix + " ");
        preOrderTraversalUtils(node.left, "L");
        preOrderTraversalUtils(node.right, "R");
    }

    public void preOrderTraversal() {
        this.preOrderTraversalUtils(this.root, "RT");
        System.out.println();
    }

    public int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Iterative way to calculate the height of the tree for the give Node.
    public int heightIterative(Node node) {
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
            if(!queue.isEmpty()) height++;
        }
        return height;
    }

    public static class Node {
        public int data;
        public Node left, right, parent;

        public Node(int data) {
            this.data = data;
            this.left = this.right = this.parent = null;
        }
    }

}
