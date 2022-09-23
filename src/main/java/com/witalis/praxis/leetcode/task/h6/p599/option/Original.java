package com.witalis.praxis.leetcode.task.h6.p599.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 599
 * Name: Minimum Index Sum of Two Lists
 * URL: <a href="https://leetcode.com/problems/minimum-index-sum-of-two-lists/">Minimum Index Sum of Two Lists</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] list1;
    private String[] list2;

    public String[] process() {
        return findRestaurant(list1, list2);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null) return new String[0];

        int n1 = list1.length;
        int n2 = list2.length;

        List<String> commonStrings = new ArrayList<>();

        Map<String, Integer> indices = new HashMap<>();

        for (int i = 0; i < n1; i++) indices.put(list1[i], i);

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n2; i++) {
            if (indices.containsKey(list2[i])) {
                int sum = indices.get(list2[i]) + i;
                if (minSum >= sum) {
                    if (minSum > sum) {
                        commonStrings.clear();
                        minSum = sum;
                    }
                    commonStrings.add(list2[i]);
                }
            }
        }

        return commonStrings.toArray(new String[0]);
    }
}
