package org.example.Trie;

import java.util.*;
import java.util.function.Function;

public class WordDictionary {
    static class TrieNode {
        Map<Character, TrieNode> map;
        boolean isComplete;

        public TrieNode() {
            map = new HashMap<>();
            isComplete = false;
        }
    }

    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            if (!node.map.containsKey(c)) {
                node.map.put(c, new TrieNode());
            }
            node = node.map.get(c);
        }
        node.isComplete = true;
    }

    public boolean search(String word) {
        ArrayList<TrieNode> nodes = new ArrayList<>();
        nodes.add(root);
        for (char c: word.toCharArray()){
            ArrayList<TrieNode> fNodes = new ArrayList<>();
            if(c == '.'){
                for (TrieNode node : nodes){
                    fNodes.addAll(node.map.values());
                }
            }else{
                for (TrieNode node : nodes){
                    if(node.map.containsKey(c)) fNodes.add(node.map.get(c));
                }
            }
            if(fNodes.isEmpty()) return false;
            nodes = fNodes;
        }

        for(TrieNode node : nodes){
            if(node.isComplete) return true;
        }
        return false;
    }
}
