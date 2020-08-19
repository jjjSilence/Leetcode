package com.jjj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q_79 {

    public static void main(String[] args) {
        System.out.print("ok\n");
        char[][] chars = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        char[][] chars = new char[][]{{'A', 'B', 'C', 'E'}};
        boolean exist = exist(chars, "ABCD");
        System.out.print(exist);
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        boolean[][] flags = new boolean[board.length][board[0].length];
        for (int y = 0; y < board.length; y++) {
            char[] chars = board[y];
            for (int x = 0; x < chars.length; x++) {
                if (chars[x] == word.charAt(0)) {
                    flags[y][x] = true;
                    if (dfs(board, word, flags, 1, x, y)) {
                        return true;
                    }
                    flags[y][x] = false;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, boolean[][] flags, int depth, int x, int y) {
        if (depth == word.length()) {
            return true;
        }
        List<Bean> list = new ArrayList<>(4);
        if (x - 1 >= 0 && !flags[y][x - 1]) {
            list.add(new Bean(board[y][x - 1], x - 1, y));
        }
        if (x + 1 < board[0].length && !flags[y][x + 1]) {
            list.add(new Bean(board[y][x + 1], x + 1, y));
        }
        if (y - 1 >= 0 && !flags[y - 1][x]) {
            list.add(new Bean(board[y - 1][x], x, y - 1));
        }
        if (y + 1 < board.length && !flags[y + 1][x]) {
            list.add(new Bean(board[y + 1][x], x, y + 1));
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).c == word.charAt(depth)) {
                flags[y][x] = true;
                if (dfs(board, word, flags, depth + 1, list.get(i).x, list.get(i).y)) {
                    return true;
                }
                flags[y][x] = false;
            }
        }
        return false;
    }

    static class Bean {
        char c;
        int x;
        int y;

        Bean(char c, int x, int y) {
            this.c = c;
            this.x = x;
            this.y = y;
        }
    }
}
