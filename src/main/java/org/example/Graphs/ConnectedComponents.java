package org.example.Graphs;

import java.util.Map;
import java.util.Set;

public class ConnectedComponents {
    public static void start(){
        Graph g = new Graph();
        g.addBiDirectionalEdge(1, 4);
        g.addBiDirectionalEdge(1, 2);
        g.addBiDirectionalEdge(1, 3);
        g.addBiDirectionalEdge(2, 3);
        g.addBiDirectionalEdge(3, 5);
        g.addBiDirectionalEdge(4, 5);
        g.addBiDirectionalEdge(3, 6);

        g.addBiDirectionalEdge(8, 7);
        g.addBiDirectionalEdge(7, 9);

        g.addBiDirectionalEdge(11, 10);
        g.addBiDirectionalEdge(10, 12);

        System.out.println();
        Map<Integer, Set<Integer>> result = g.getConnectedComponents();
        for(Map.Entry<Integer, Set<Integer>> entry : result.entrySet()){
            for(Integer node : entry.getValue()){
                System.out.println("Connected Node : " + entry.getKey() + " :: " + node);
            }
        }
    }
}
