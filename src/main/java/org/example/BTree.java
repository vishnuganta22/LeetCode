package org.example;

public class BTree {

    private final int T;
    private final int full;

    public class Node {
        int n;
        int[] key = new int[full - 1];
        Node[] child = new Node[full];
        boolean leaf = true;

        public int Find(int k) {
            for (int i = 0; i < this.n; i++) {
                if (this.key[i] == k) {
                    return i;
                }
            }
            return -1;
        };
    }

    public BTree(int t) {
        T = t;
        full = (3 * t) / 2;
        root = new Node();
        root.n = 0;
        root.leaf = true;
    }

    private Node root;

    private void split(Node x, int pos, Node y) {
        Node z = new Node();
        z.leaf = y.leaf;
        z.n = T-1;
        for (int j = 0; j < (T - 1); j++) {
            z.key[j] = y.key[j + T];
        }
        if (!y.leaf) {
            for (int j = 0; j < T; j++) {
                z.child[j] = y.child[j + T];
            }
        }
        y.n = (T - 1);
        for (int j = x.n; j >= pos + 1; j--) {
            x.child[j + 1] = x.child[j];
        }
        x.child[pos + 1] = z;

        for (int j = x.n - 1; j >= pos; j--) {
            x.key[j + 1] = x.key[j];
        }
        x.key[pos] = y.key[T - 1];
        x.n = x.n + 1;
    }

    public void insert(final int key) {
        Node r = root;
        if (r.n == full - 1) {
            Node s = new Node();
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            split(s, 0, r);
            insertUtils(s, key);
        } else {
            insertUtils(r, key);
        }
    }
    private void insertUtils(Node x, int k) {
        int i = 0;
        if (x.leaf) {
            for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
                x.key[i + 1] = x.key[i];
            }
            x.key[i + 1] = k;
            x.n = x.n + 1;
        } else {
            for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
            }
            i++;
            Node tmp = x.child[i];
            if (tmp.n == full - 1) {
                split(x, i, tmp);
                if (k > x.key[i]) {
                    i++;
                }
            }
            insertUtils(x.child[i], k);
        }

    }

    public void display() {
        displayUtils(root);
    }

    private void displayUtils(Node x) {
        assert (x == null);
        for (int i = 0; i < x.n; i++) {
            System.out.print(x.key[i] + " ");
        }
        if (!x.leaf) {
            for (int i = 0; i < x.n + 1; i++) {
                displayUtils(x.child[i]);
            }
        }
    }
}
