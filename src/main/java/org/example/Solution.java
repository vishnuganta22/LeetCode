package org.example;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static class SinglyLinkedListNode{
        int data;
        SinglyLinkedListNode next;
    }

    private static void print(SinglyLinkedListNode root){
        SinglyLinkedListNode temp = root;
        System.out.print("[ ");
        while (temp != null){
            System.out.print(temp.data);
            temp = temp.next;
            if(temp != null){
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }

    public static SinglyLinkedListNode generate(SinglyLinkedListNode root){
        Map<Integer, Integer> map = new HashMap<>();
        SinglyLinkedListNode temp = root;
        int prev = Integer.MAX_VALUE;
        int index = 0;
        int c = 1;
        while (temp != null){
            if(temp.data <= prev){
                c = c + 1;
                map.put(index, c);
            }else{
                map.put(index, 1);
                c = 1;
            }
            index++;
            prev = temp.data;
            temp = temp.next;
        }

        int finalIndex = 0;
        int finalSize = 0;
        for (Integer k : map.keySet()){
            if(finalSize < map.get(k)){
                finalSize = map.get(k);
                finalIndex = k;
            }
        }
        int startIndex = finalIndex - finalSize + 1;
        System.out.println(startIndex + " :: " + finalSize);
        SinglyLinkedListNode t = root;
        while (startIndex > 0){
            t = t.next;
            startIndex--;
        }
        SinglyLinkedListNode e = t;
        while (finalSize > 1){
            e = e.next;
            finalSize--;
        }
        e.next = null;
        return t;
    }

    public static void main(String[] args){
        int[] arr = new int[]{2, 11, 9, 6, 4, 3, 2, 1, 5, 5, 4, 4, 3, 1, 2};
        SinglyLinkedListNode root = new SinglyLinkedListNode();
        SinglyLinkedListNode temp = root;
        for (int i = 0; i < arr.length - 1; i++){
            temp.data = arr[i];
            temp.next = new SinglyLinkedListNode();
            temp = temp.next;
        }
        temp.data = arr[arr.length - 1];
        print(root);
        print(generate(root));
    }
}
