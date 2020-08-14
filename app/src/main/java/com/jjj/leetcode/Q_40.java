package com.jjj.leetcode;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q_40 {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        System.out.print("ok\n");

        combinationSum2(new int[]{2, 3}, 5);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<List<Integer>> combinationSum2(final int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Set<List<Integer>>> m = new HashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            final int num = candidates[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            Set<List<Integer>> set = new HashSet<>();
            set.add(new ArrayList<Integer>() {{
                add(num);
            }});
            m.put(num, set);
        }

        int index = 0;
        while (index <= target) {
            Set<List<Integer>> list = new HashSet<>();
            int end = index / 2;
            for (int i = 0; i <= end; i++) {
                Set<List<Integer>> list1 = m.getOrDefault(i, new HashSet<List<Integer>>(0));
                Set<List<Integer>> list2 = m.getOrDefault(index - i, new HashSet<List<Integer>>(0));
                if (list1.size() > 0 && list2.size() > 0) {
                    for (List<Integer> l1 : list1) {
                        for (List<Integer> l2 : list2) {
                            List list3 = new ArrayList<>();
                            list3.addAll(l1);
                            list3.addAll(l2);
                            if (check(list3, map)) {
                                list.add(list3);
                            }
                        }
                    }
                }
            }
            Set set = m.getOrDefault(index, new HashSet());
            set.addAll(list);
            m.put(index, set);

            index++;
        }

        if (m.get(target) != null) {
            result.addAll(m.get(target));
        }
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + "; ");
            }
            System.out.print("\n");
        }
        return result;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean check(List<Integer> newList, Map<Integer, Integer> map) {
        newList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : 0;
            }
        });
        Map<Integer, Integer> map1 = new HashMap<>();
        for (Integer i : newList) {
            int num = map1.getOrDefault(i, 0) + 1;
            if (num > map.get(i)) {
                return false;
            }
            map1.put(i, num);
        }
        return true;
    }
}
