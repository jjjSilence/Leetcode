package com.jjj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q_60 {
    public static void main(String[] args) {
        System.out.print("ok\n");
        System.out.println(getPermutation(4, 9));
    }

    public static String getPermutation(int n, int k) {
        List<Integer> selectable = new ArrayList<>(n);
        int total = 1;
        for (int i = 1; i <= n; i++) {
            selectable.add(i);
            total = total * i;
        }
        return dfs(selectable, new ArrayList<Integer>(), total, n, k, 0);
    }


    private static String dfs(List<Integer> selectable, List<Integer> selected, int total, int n, int k, int cut) {
        for (int i = 0; i < selectable.size(); i++) {
            if (selected.contains(selectable.get(i))) {
                continue;
            }
            int diff = total / n;
            int start = diff * i + 1 + cut;
            int end = start + diff - 1;
            if (k >= start && k <= end) {
                selected.add(selectable.get(i));
                selectable.remove(i);
                if (selectable.size() == 0) {
                    StringBuilder builder = new StringBuilder();
                    for (Integer num : selected) {
                        builder.append(num);
                    }
                    return builder.toString();
                }
                int tempCut = i * diff;
                return dfs(selectable, selected, total / n, n - 1, k, cut + tempCut);
            }
        }
        return "";
    }
}
