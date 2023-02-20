package com.witalis.praxis.leetcode.task.h8.p747.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 747
 * Name: Largest Number At Least Twice of Others
 * URL: <a href="https://leetcode.com/problems/largest-number-at-least-twice-of-others/">Largest Number At Least Twice of Others</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return dominantIndex(numbers);
    }

    public int dominantIndex(int[] nums) {
        if (nums == null) return -1;

        final int[] dominants = new int[] {-1, -1, -1};
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > dominants[1]) {
                dominants[0] = dominants[1];
                dominants[1] = nums[i];
                dominants[2] = i;
            } else if (nums[i] > dominants[0]) {
                dominants[0] = nums[i];
            }
        }

        return dominants[1] >= 2 * dominants[0] ? dominants[2] : -1;
    }
}
