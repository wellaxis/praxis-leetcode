package com.witalis.praxis.leetcode.task.h6.p594.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 594
 * Name: Longest Harmonious Subsequence
 * URL: <a href="https://leetcode.com/problems/longest-harmonious-subsequence/">Longest Harmonious Subsequence</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return findLHS(numbers);
    }

    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int lhs = 0;
        for (Integer num : map.keySet()) {
            if (map.containsKey(num - 1) || map.containsKey(num + 1)) {
                lhs = Math.max(lhs, map.get(num) + Math.max(map.getOrDefault(num - 1, 0), map.getOrDefault(num + 1, 0)));
            }
        }

        return lhs;
    }
}
