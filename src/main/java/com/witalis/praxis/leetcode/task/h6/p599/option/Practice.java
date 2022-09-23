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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] list1;
    private String[] list2;

    public String[] process() {
        return findRestaurant(list1, list2);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null) return new String[0];

        List<String> commonStrings = new ArrayList<>();

        Map<String, Integer> indices = new HashMap<>();

        for (int i = 0; i < list1.length; i++) indices.put(list1[i], i);

        int minSum = Integer.MAX_VALUE;
        int sum;
        for (int i = 0; i < list2.length; i++) {
            if (indices.containsKey(list2[i])) {
                sum = indices.get(list2[i]) + i;
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
