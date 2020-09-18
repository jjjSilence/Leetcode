package com.jjj.leetcode;


public class Q_62 {
    public static void main(String[] args) {
        System.out.print("ok\n");
        System.out.println(uniquePaths(2, 3));
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));

        Thread
    }

    public static int uniquePaths(int m, int n) {
        dfs(m, n, 0, 0);
        return count;


    }

    private static int count = 0;

    private static void dfs(int m, int n, int x, int y) {
        if (x == m || y == n) {
            count++;
            return;
        }
        for (int i = 0; i < 2; i++) {
            x = i == 1 ? x + 1 : x;
            y = i == 1 ? y : y + 1;
            if (x <= m && y <= n) {
                dfs(m, n, x, y);
            }
        }
    }

    private static class Bean {
        int x;
        int y;

        public Bean(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
