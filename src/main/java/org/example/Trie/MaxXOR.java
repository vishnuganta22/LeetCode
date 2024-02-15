package org.example.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// LeetCode 1707
public class MaxXOR {
    static class TNode {
        public TNode[] map = new TNode[2];
    }

    record Query(int x, int m, int index) {
    }

    public static int[] maximizeXOR(int[] nums, int[][] queries) {
        Arrays.sort(nums);

        int size = queries.length;
        List<Query> queryList = new ArrayList<>();
        int index = 0;
        for (int[] q : queries) {
            queryList.add(new Query(q[0], q[1], index));
            index++;
        }
        queryList.sort(Comparator.comparingInt(o -> o.m));

        int position = 0;
        int[] result = new int[size];
        TNode trie = new TNode();
        for (Query query : queryList) {
            System.out.println("Querying :: [" + query.x + " , "+ query.m + "] from trie.");
            if (position == 0 && query.m < nums[position]) {
                result[query.index] = -1;
                continue;
            }

            while (position < nums.length && query.m >= nums[position]) {
                int num = nums[position];
                System.out.println("Inserting :: " + num + " into trie.");
                TNode temp = trie;
                for (int i = 31; i >= 0; i--) {
                    int data = ((num >> i) & 1);
                    if (temp.map[data] == null) {
                        TNode newNode = new TNode();
                        temp.map[data] = newNode;
                    }
                    temp = temp.map[data];
                }
                position++;
            }

            int tData = getTData(query, trie);
            result[query.index] = tData;
        }
        return result;
    }

    private static int getTData(Query query, TNode trie) {
        TNode temp = trie;
        int tData = 0;
        for(int i = 31; i >= 0; i--){
            int data = (query.x >> i) & 1;
            int t = 0;
            TNode tNode;
            if(data == 1){
                tNode = temp.map[0];
                if(tNode == null){
                    tNode = temp.map[1];
                    t = 1;
                }
            }else {
                tNode = temp.map[1];
                t = 1;
                if(tNode == null){
                    tNode = temp.map[0];
                    t = 0;
                }
            }
            temp = tNode;
            tData = ((tData << 1) | t);
        }
        return (query.x ^ tData);
    }

    public static void main(String[] args){
        int[] nums = {818702963,153655392,4096,917434814,4096};
        int[][] queries = {{11886620,881210474},{811373,1000000000},{20352316,1000000000},
                {443746890,860009574},{872954994,1000000000}};
        System.out.println("Result :: " + Arrays.toString(maximizeXOR(nums, queries)));
    }
}
