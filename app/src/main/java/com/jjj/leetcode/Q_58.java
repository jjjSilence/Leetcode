package com.jjj.leetcode;

public class Q_58 {
    public static void main(String[] args) {
        System.out.print("ok\n");
        System.out.print(lengthOfLastWord2("a    "));
    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] nums = s.trim().split(" ");
        if (nums == null) {
            return s.length();
        }
        return nums[nums.length - 1].length();
    }

    public static int lengthOfLastWord2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int startIndex = -1;
        int i = s.length() - 1;
        while (i >= 0) {
            char c = s.charAt(i);
            if (c != ' ' && startIndex == -1) {
                if (i == 0) {
                    return 1;
                } else {
                    startIndex = i;
                }
            } else if (startIndex != -1) {
                if (c == ' ') {
                    return startIndex - i;
                } else if (i == 0) {
                    return startIndex - i + 1;
                }
            }
            i--;
        }
        return 0;
    }
}
