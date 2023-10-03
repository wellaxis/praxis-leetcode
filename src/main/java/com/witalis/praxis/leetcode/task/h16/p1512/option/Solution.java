package com.witalis.praxis.leetcode.task.h16.p1512.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1512
 * Name: Number of Good Pairs
 * URL: <a href="https://leetcode.com/problems/number-of-good-pairs/">Number of Good Pairs</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return numIdenticalPairs(numbers);
    }

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int ans = 0;

        for (int num : nums) {
            ans += counts.getOrDefault(num, 0);
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        return ans;
    }
}
