package com.jjj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q_43 {
    public static void main(String[] args) {
        System.out.print("ok\n");
        List<List<Integer>> result = permuteUnique(new int[]{1, 1, 3});
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + "; ");
            }
            System.out.print("\n");
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        list(new ArrayList<Integer>(), nums, result, new boolean[nums.length], 0);
        return result;
    }

    public static void list(List<Integer> selectedList, int[] selectableList, List<List<Integer>> result, boolean[] used, int depth) {
        if (selectedList.size() == selectableList.length) {
            result.add(new ArrayList(selectedList));
            return;
        }
        for (Integer i = 0; i < selectableList.length; i++) {
            Integer num = selectableList[i];
            if (used[i]) {
                continue;
            }
            if (i >= 1 && !used[i - 1] && selectableList[i] == selectableList[i - 1]) {
                continue;
            }

            selectedList.add(num);
            used[i] = true;
            list(selectedList, selectableList, result, used, depth + 1);
            selectedList.remove(num);
            used[i] = false;
        }
    }
}
