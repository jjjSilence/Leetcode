package com.jjj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q_49 {
    public static void main(String[] args) {
        System.out.print("ok\n");

        List<List<String>> list = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + "; ");
            }
            System.out.print("\n");
        }
    }

    public static List<List<String>> groupAnagrams(final String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] flags = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (flags[i]) {
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            flags[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if (flags[j]) {
                    continue;
                }
                if (isEqual(strs[i], strs[j])) {
                    list.add(strs[j]);
                    flags[j] = true;
                }
            }
            result.add(list);
        }

        return result;
    }


    public static boolean isEqual(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        boolean[] flags = new boolean[word1.length()];
        for (int i = 0; i < word1.length(); i++) {
            boolean march = false;
            for (int j = 0; j < word2.length(); j++) {
                if (!flags[j] && word1.charAt(i) == word2.charAt(j)) {
                    flags[j] = true;
                    march = true;
                    break;
                }
            }
            if (!march) {
                return false;
            }
        }
        return true;
    }
}
