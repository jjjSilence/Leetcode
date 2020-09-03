package com.jjj.leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode transform(int[] nums) {
        ListNode head = null;
        ListNode listNode = null;
        for (int i : nums) {
            if (head == null) {
                listNode = new ListNode(i);
                head = listNode;
            } else {
                listNode.next = new ListNode(i);
                listNode = listNode.next;
            }
        }
        return head;
    }

    public static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + "; ");
            listNode = listNode.next;
        }
        System.out.println(" ");
    }
}
