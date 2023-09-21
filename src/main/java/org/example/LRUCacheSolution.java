package org.example;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheSolution {
    static class Node{
        int data;
        int key;
        Node prev;
        Node next;

        Node(int key, int data){
            this.key = key;
            this.data = data;
        }

        Node(int key, int data, Node prev, Node next){
            this.key = key;
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    static class LRUCache {

        private Node head;
        private Node trail;
        private final int capacity;
        private Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.head = null;
            this.trail = null;
            this.capacity = capacity;
            this.map = new HashMap<>();
        }

        private void remove(Node i){
            Node prev = i.prev;
            Node next = i.next;

            if(prev != null) prev.next = next;
            else this.head = next;
            if(next != null) next.prev = prev;
            else this.trail = prev;
        }

        private void addAtEnd(Node i){
            if(this.head == null && this.trail == null){
                this.head = this.trail = i;
                this.head.prev = null;
            }else{
                i.prev = trail;
                this.trail.next = i;
                this.trail = i;
            }
            this.trail.next = null;
        }

        public int get(int key) {
            Node i = map.getOrDefault(key, null);
            if(i != null){
                remove(i);
                addAtEnd(i);
            }
            return i != null ? i.data : -1;
        }

        public void put(int key, int value) {
            if(this.map.isEmpty()){
                this.head = this.trail = new Node(key, value);
                this.map.put(key, this.head);
                return;
            }

            if(map.containsKey(key)){
                Node i = map.get(key);
                remove(i);
                addAtEnd(i);
                i.data = value;
            }else{
                if(this.map.size() < this.capacity){
                    Node i = new Node(key, value);
                    map.put(key, i);
                    addAtEnd(i);
                }else{
                    Node next = this.head.next;
                    this.map.remove(this.head.key);
                    this.head = next;

                    if(this.head == null){
                        Node i = new Node(key, value);
                        this.map.put(key, i);
                        this.head = this.trail = i;
                    }else{
                        this.head.prev = null;
                        Node i = new Node(key, value);
                        this.map.put(key, i);
                        addAtEnd(i);
                    }
                }
            }
        }
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5, 5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
    }
}
