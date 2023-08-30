package com.witalis.praxis.leetcode.task.h24.p2366.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2366
 * Name: Minimum Replacements to Sort the Array
 * URL: <a href="https://leetcode.com/problems/minimum-replacements-to-sort-the-array/">Minimum Replacements to Sort the Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Long process() {
        return minimumReplacement(numbers);
    }

    public long minimumReplacement(int[] nums) {
        if (nums == null) return 0L;

        long replacements = 0;

        final int n = nums.length;

        int previous = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int current = nums[i];

            int operations = current / previous;
            if (current % previous != 0) {
                operations++;
                previous = current / operations;
            }
            replacements += operations - 1;
        }

        return replacements;
    }
}
