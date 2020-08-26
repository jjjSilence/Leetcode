package com.jjj.leetcode;

public class Q_59 {
    public static void main(String[] args) {
        System.out.print("ok\n");
        int[][] nums = generateMatrix(2);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                System.out.print(nums[i][j] + ",");
            }
            System.out.println("");
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        boolean leftFlag = false, rightFlag = false, topFlag = true, bottomFlag = false;
        int index = 1;
        int total = n * n;
        while (index <= total) {
            if (topFlag) {
                for (int i = left; i <= right; i++) {
                    result[top][i] = index++;
                }
                rightFlag = true;
                topFlag = false;
                top++;
            } else if (rightFlag) {
                for (int i = top; i <= bottom; i++) {
                    result[i][right] = index++;
                }
                bottomFlag = true;
                rightFlag = false;
                right--;
            } else if (bottomFlag) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = index++;
                }
                leftFlag = true;
                bottomFlag = false;
                bottom--;
            } else if (leftFlag) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = index++;
                }
                topFlag = true;
                leftFlag = false;
                left++;
            }
        }
        return result;
    }
}
