package org.example.Graphs;

public class DepthFirstSearch {
    public static void start(){
        Graph g = new Graph();
        g.addBiDirectionalEdge(0, 1);
        g.addBiDirectionalEdge(0, 9);
        g.addBiDirectionalEdge(1, 2);
        g.addBiDirectionalEdge(2, 0);
        g.addBiDirectionalEdge(2, 3);
        g.addBiDirectionalEdge(9, 3);

        System.out.println("Following is Depth First Traversal");
        g.DFS();
        System.out.println();
        System.out.println("Following is Depth First Traversal with base case");
        g.baseDFS(2);
    }
}
