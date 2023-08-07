package org.example.Trie;

import org.example.Trie.AutocompleteSystem;

public class AutocompleteTest {
    public static void main(String[] args){
        testCase2();
    }

    private static void testCase2(){
        AutocompleteSystem system = new AutocompleteSystem(new String[]{"abc","abbc","a"}, new int[]{3,3,3});
        system.input('b');
        system.input('c');
        system.input('#');
        system.input('b');
        system.input('c');
        system.input('#');
        system.input('a');
    }

    private static void testCase1(){
        AutocompleteSystem system = new AutocompleteSystem(new String[]{"i love you","island","iroman","i love leetcode"}, new int[]{5,3,2,2});
        system.input('i');
        system.input(' ');
        system.input('a');
        system.input('#');
    }
}
