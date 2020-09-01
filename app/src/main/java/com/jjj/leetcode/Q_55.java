package com.jjj.leetcode;

public class Q_55 {
    public static void main(String[] args) {
        System.out.print("ok\n");
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        int startIndex = 0;
        int endIndex = nums[0];
        while (startIndex <= endIndex) {
            endIndex = Math.max(endIndex, startIndex + nums[startIndex]);
            if (endIndex >= nums.length - 1) {
                return true;
            }
            startIndex++;
        }
        return false;
    }
}
