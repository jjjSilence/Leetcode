package com.jjj.leetcode;

public class Q_45 {
    public static void main(String[] args) {
        System.out.print("ok\n");

        System.out.print(searchInsert(new int[]{1, 3, 5, 6}, 12) + "\n");
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (target > nums[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        System.out.print("start = " + start + "; end = " + end + "\n");
        return start;
    }
}
