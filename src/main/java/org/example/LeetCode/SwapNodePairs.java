package org.example.LeetCode;

public class SwapNodePairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    static class Solution {
        private ListNode swapPairsUtils(ListNode node){
            if (node == null) return null;
            if (node.next == null) return node;
            ListNode rNode = node.next.next;
            ListNode nNode = node.next;
            nNode.next = node;
            node.next = swapPairsUtils(rNode);
            return nNode;
        }

        public ListNode swapPairs(ListNode head) {
            return swapPairsUtils(head);
        }
    }
}
