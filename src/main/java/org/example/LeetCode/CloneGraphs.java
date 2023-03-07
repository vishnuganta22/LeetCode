package org.example.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraphs {
    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    static class Solution {
        Map<Integer, Node> nodeMap = new HashMap<>();
        public Node cloneGraph(Node node) {
            if(node == null) return null;
            if(nodeMap.containsKey(node.val)) return nodeMap.get(node.val);

            Node clone = new Node(node.val);
            nodeMap.put(node.val, clone);
            for (Node neighborNode: node.neighbors) {
                clone.neighbors.add(cloneGraph(neighborNode));
            }
            return clone;
        }
    }
}
