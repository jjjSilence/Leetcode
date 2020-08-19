package com.jjj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q_54 {
    public static void main(String[] args) {
        System.out.print("ok\n");

//        int[][] nums = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] nums = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        List<Integer> list = spiralOrder(nums);
        for (Integer i : list) {
            System.out.print(i + ";  ");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>(0);
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        boolean leftEnable = false;
        boolean rightEnable = false;
        boolean topEnable = true;
        boolean bottomEnable = false;

        int x = left;
        int y = top;
        List<Integer> result = new ArrayList<>();
        while (left <= right && top <= bottom) {
            result.add(matrix[y][x]);
            if (topEnable) {
                if (x == right) {
                    y++;
                    top++;
                    topEnable = false;
                    rightEnable = true;
                } else {
                    x++;
                }
            } else if (rightEnable) {
                if (y == bottom) {
                    x--;
                    right--;
                    rightEnable = false;
                    bottomEnable = true;
                } else {
                    y++;
                }
            } else if (bottomEnable) {
                if (x == left) {
                    y--;
                    bottom--;
                    bottomEnable = false;
                    leftEnable = true;
                } else {
                    x--;
                }
            } else if (leftEnable) {
                if (y == top) {
                    x++;
                    left++;
                    leftEnable = false;
                    topEnable = true;
                } else {
                    y--;
                }
            }
        }
        return result;
    }
}
