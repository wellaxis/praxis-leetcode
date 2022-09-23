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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] list1;
    private String[] list2;

    public String[] process() {
        return findRestaurant(list1, list2);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        int n1 = list1.length;
        int n2 = list2.length;
        int min = Integer.MAX_VALUE;
        int sum;
        String s2;

        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < n1; i++) map.put(list1[i], i);

        for (int j = 0; j < n2 && j <= min; j++) {
            s2 = list2[j];
            if (map.containsKey(s2)) {
                sum = j + map.get(s2);
                if (sum < min) {
                    res.clear();
                    res.add(s2);
                    min = sum;
                } else if (sum == min) res.add(s2);
            }
        }

        return res.toArray(new String[res.size()]);
    }
}
