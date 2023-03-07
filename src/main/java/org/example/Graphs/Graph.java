package org.example.Graphs;

import java.util.*;

public class Graph {
    private final Map<Integer, Set<Integer>> adjacencyList;
    private final Map<Integer, Boolean> nodeVisited;

    public Graph() {
        this.adjacencyList = new HashMap<>();
        this.nodeVisited = new HashMap<>();
    }

    public Map<Integer, Set<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public void addEdge(int v, int w) {
        Set<Integer> list = adjacencyList.get(v);
        if (list == null) {
            list = new HashSet<>();
        }
        list.add(w);
        adjacencyList.put(v, list);
    }

    public void addBiDirectionalEdge(int v, int w){
        Set<Integer> vList = adjacencyList.get(v);
        Set<Integer> wList = adjacencyList.get(w);

        if(vList == null){
            vList = new HashSet<>();
        }

        if(wList == null){
            wList = new HashSet<>();
        }
        vList.add(w);
        wList.add(v);
        adjacencyList.put(v, vList);
        adjacencyList.put(w, wList);
    }

    private void DFSUtils(Integer node) {
        if (nodeVisited.get(node) != null && nodeVisited.get(node)) return;

        nodeVisited.put(node, true);

        System.out.print(node + " ");
        if(adjacencyList.get(node) != null){
            for (Integer i : adjacencyList.get(node)) {
                if (nodeVisited.get(i) == null || !nodeVisited.get(i)) {
                    DFSUtils(i);
                }
            }
        }
    }

    public void DFS() {
        for (Integer i : adjacencyList.keySet()) {
            if (nodeVisited.get(i) == null || !nodeVisited.get(i)) {
                DFSUtils(i);
            }
        }
        clearNodeVisited();
    }

    private void baseDFSUtils(Integer node) {
        if (nodeVisited.get(node) != null && nodeVisited.get(node)) return;

        nodeVisited.put(node, true);

        System.out.print(node + " ");
        if(adjacencyList.get(node) != null){
            for (Integer i : adjacencyList.get(node)) {
                if (nodeVisited.get(i) == null || !nodeVisited.get(i)) {
                    baseDFSUtils(i);
                }
            }
        }
    }

    public void baseDFS(Integer node) {
        baseDFSUtils(node);
        clearNodeVisited();
    }

    private void connectedComponentUtils(Integer node, Set<Integer> connectedNodes){
        if(nodeVisited.get(node) != null && nodeVisited.get(node)) return;

        nodeVisited.put(node, true);

        connectedNodes.add(node);
        if(adjacencyList.get(node) != null){
            for (Integer i : adjacencyList.get(node)) {
                if (nodeVisited.get(i) == null || !nodeVisited.get(i)) {
                    connectedComponentUtils(i, connectedNodes);
                }
            }
        }
    }

    public Map<Integer, Set<Integer>> getConnectedComponents(){
        Map<Integer, Set<Integer>> result = new HashMap<>();
        int k = 0;
        for(Map.Entry<Integer, Set<Integer>> entry : adjacencyList.entrySet()){
            Integer node = entry.getKey();
            boolean isVisited = nodeVisited.get(node) != null && nodeVisited.get(node);
            if(!isVisited){
                Set<Integer> connectedNodes = new HashSet<>();
                result.put(k, connectedNodes);
                connectedComponentUtils(node, connectedNodes);
                k++;
            }
        }
        nodeVisited.clear();
        return result;
    }

    private void clearNodeVisited() {
        this.nodeVisited.clear();
    }
}
