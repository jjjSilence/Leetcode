package com.jjj.leetcode;

public class Q_53 {
    public static void main(String[] args) {
        System.out.print("ok\n");
        System.out.println(maxSubArray(new int[]{-2, 1}));
//        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                result = Math.max(sum, result);
            }
        }
        return result;
    }
}
