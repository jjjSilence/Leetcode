package com.jjj.leetcode;

public class Q_61 {
    public static void main(String[] args) {
        System.out.print("ok\n");
        ListNode head = ListNode.transform(new int[]{1, 2, 3});
        ListNode.print(rotateRight(head, 1));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }

        ListNode listNode = head;
        int size = 0;
        while (listNode != null) {
            listNode = listNode.next;
            size++;
        }
        if (size <= 1) {
            return head;
        }

        k = k % size;
        if (k == 0) {
            return head;
        }

        int i = 0;
        ListNode left = null;
        ListNode leftHead = null;
        ListNode right = null;
        ListNode rightHead = null;
        listNode = head;
        while (listNode != null) {
            if (i < size - k) {
                if (leftHead == null) {
                    left = new ListNode(listNode.val);
                    leftHead = left;
                } else {
                    left.next = new ListNode(listNode.val);
                    left = left.next;
                }
            } else {
                if (rightHead == null) {
                    right = new ListNode(listNode.val);
                    rightHead = right;
                } else {
                    right.next = new ListNode(listNode.val);
                    right = right.next;
                }
            }
            listNode = listNode.next;
            i++;
        }

        ListNode.print(leftHead);
        ListNode.print(rightHead);

        if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right != null) {
            right.next = leftHead;
            return rightHead;
        }
        return head;
    }
}
