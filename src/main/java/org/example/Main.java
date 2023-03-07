package org.example;

public class Main {
    public static class Node {
        Node left, right;
        int data;
        boolean lThread;
        boolean rThread;
    }

    public static class BinarySearchTree {
        private Node root;

        public void insert(int data) {
            Node ptr = root;
            Node par = null;
            while (ptr != null) {
                if (data == (ptr.data)) return;
                par = ptr;
                if (data < ptr.data) {
                    if (!ptr.lThread) ptr = ptr.left;
                    else break;
                } else {
                    if (!ptr.rThread) ptr = ptr.right;
                    else break;
                }
            }
            Node tmp = new Node();
            tmp.data = data;
            tmp.lThread = true;
            tmp.rThread = true;

            if (par == null) {
                root = tmp;
                tmp.left = null;
                tmp.right = null;
            } else if (data < (par.data)) {
                tmp.left = par.left;
                tmp.right = par;
                par.lThread = false;
                par.left = tmp;
            } else {
                tmp.left = par;
                tmp.right = par.right;
                par.rThread = false;
                par.right = tmp;
            }
        }

        public void delete(int data) {
            Node par = null, ptr = root;
            int found = 0;
            while (ptr != null) {
                if (data == ptr.data) {
                    found = 1;
                    break;
                }
                par = ptr;
                if (data < ptr.data) {
                    if (!ptr.lThread) ptr = ptr.left;
                    else break;
                } else {
                    if (!ptr.rThread) ptr = ptr.right;
                    else break;
                }
            }

            if (found == 0)
                System.out.println("data not present in tree");
            else if (!ptr.lThread && !ptr.rThread)
                root = caseC(root, par, ptr);
            else if (!ptr.lThread)
                root = caseB(root, par, ptr);
            else if (!ptr.rThread)
                root = caseB(root, par, ptr);
            else
                root = caseA(root, par, ptr);
        }

        private Node caseA(Node root, Node par, Node ptr) {
            if (par == null)
                root = null;
            else if (ptr == par.left) {
                par.lThread = true;
                par.left = ptr.left;
            } else {
                par.rThread = true;
                par.right = ptr.right;
            }
            return root;
        }

        private Node caseB(Node root, Node par, Node ptr) {
            Node child;
            if (!ptr.lThread) child = ptr.left;
            else child = ptr.right;

            if (par == null) root = child;
            else if (ptr == par.left) par.left = child;
            else par.right = child;

            Node s = inSucc(ptr);
            Node p = inPred(ptr);

            if (!ptr.lThread) p.right = s;
            else {
                if (!ptr.rThread) s.left = p;
            }
            return root;
        }

        private Node caseC(Node root, Node par, Node ptr) {
            Node parsucc = ptr;
            Node succ = ptr.right;

            while (!succ.lThread) {
                parsucc = succ;
                succ = succ.left;
            }

            ptr.data = succ.data;

            if (succ.lThread && succ.rThread) root = caseA(root, parsucc, succ);
            else root = caseB(root, parsucc, succ);

            return root;
        }

        private Node inSucc(Node ptr) {
            if (ptr.rThread) return ptr.right;

            ptr = ptr.right;
            while (!ptr.lThread) ptr = ptr.left;

            return ptr;
        }

        private Node inPred(Node ptr) {
            if (ptr.lThread) return ptr.left;

            ptr = ptr.left;
            while (!ptr.rThread) ptr = ptr.right;
            return ptr;

        }

        private Node inorderSuccessor(Node ptr) {
            if (ptr.rThread) return ptr.right;
            ptr = ptr.right;
            while (!ptr.lThread) ptr = ptr.left;
            return ptr;
        }

        public void inorder() {
            if (root == null) System.out.print("Tree is empty");

            Node ptr = root;
            while (!ptr.lThread) ptr = ptr.left;

            while (ptr != null) {
                System.out.print(ptr.data + " ");
                ptr = inorderSuccessor(ptr);
            }
        }
    }

    public static void main(String[] args) {
        //DepthFirstSearch.start();
        //ConnectedComponents.start();

        SplayTree tree = new SplayTree();
        tree.insert(0);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.insert(10);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.insert(11);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.insert(4);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.insert(40);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.insert(2);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.insert(7);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.insert(-5);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.insert(9);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.insert(3);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.insert(-1);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.search(4);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.preOrderTraversal();
        tree.delete(40);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.preOrderTraversal();
        tree.delete(2);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.preOrderTraversal();
        tree.delete(7);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.preOrderTraversal();
        tree.delete(-5);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.preOrderTraversal();
        tree.insert(22);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.preOrderTraversal();
        tree.insert(29);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.preOrderTraversal();
        tree.search(39);
        tree.preOrderTraversal();
        tree.delete(12);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.preOrderTraversal();
        tree.delete(11);
        System.out.println("Height :: " + tree.height(tree.getRoot()));
        System.out.println("Height I :: " + tree.heightIterative(tree.getRoot()));
        tree.preOrderTraversal();
    }
}