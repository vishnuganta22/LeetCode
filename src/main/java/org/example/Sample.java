package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sample {
    // Online Java Compiler
    // Use this editor to write, compile and run your Java code online
    private static int test(String categories) {
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        Map<Integer, ArrayList<Character>> table = new HashMap<>();
        Map<Character, Integer> r = new HashMap<>();
        char[] arr = categories.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) map.get(arr[i]).add(i);
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }

            int pre = 0;
            for (Character c : map.keySet()) {
                int size = map.get(c).size();
                if (size > pre) {
                    ArrayList<Character> list = new ArrayList<>();
                    list.add(c);
                    table.put(i, list);
                    pre = size;
                } else if (size == pre) {
                    if (table.get(i) == null) {
                        ArrayList<Character> list = new ArrayList<>();
                        list.add(c);
                        table.put(i, list);
                        pre = size;
                    } else {
                        table.get(i).add(c);
                        pre = size;
                    }
                }
            }
        }

        for (Integer i : table.keySet()) {
            System.out.println(i + " :: " + table.get(i).toString());
            for (Character c : table.get(i)) {
                if (r.containsKey(c)) {
                    int count = r.get(c);
                    count++;
                    r.put(c, count);
                } else {
                    r.put(c, 1);
                }
            }
        }

        int result = 0;
        for (Character c : r.keySet()) {
            if (result < r.get(c)) {
                result = r.get(c);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(test("aabcaa"));
    }
}
