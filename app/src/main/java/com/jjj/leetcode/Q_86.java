package com.jjj.leetcode;

public class Q_86 {
    public static void main(String[] args) {
        System.out.print("ok\n");
        int[] nums = new int[]{};
        ListNode head = ListNode.transform(nums);
        ListNode listNode = partition(head, 3);
        ListNode.print(listNode);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode leftHead = null;
        ListNode leftListNode = null;
        ListNode rightHead = null;
        ListNode rightListNode = null;
        while (head != null) {
            if (head.val < x) {
                if (leftListNode == null) {
                    leftListNode = new ListNode(head.val);
                    leftHead = leftListNode;
                } else {
                    leftListNode.next = new ListNode(head.val);
                    leftListNode = leftListNode.next;
                }
            } else {
                if (rightListNode == null) {
                    rightListNode = new ListNode(head.val);
                    rightHead = rightListNode;
                } else {
                    rightListNode.next = new ListNode(head.val);
                    rightListNode = rightListNode.next;
                }
            }
            head = head.next;
        }

        if (leftHead != null && rightHead == null) {
            return leftHead;
        }

        if (leftHead == null && rightHead != null) {
            return rightHead;
        }

        if (leftHead != null && rightHead != null) {
            leftListNode.next = rightHead;
        }

        return leftHead;
    }
}
