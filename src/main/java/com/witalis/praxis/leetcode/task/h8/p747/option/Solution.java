package com.witalis.praxis.leetcode.task.h8.p747.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 747
 * Name: Largest Number At Least Twice of Others
 * URL: <a href="https://leetcode.com/problems/largest-number-at-least-twice-of-others/">Largest Number At Least Twice of Others</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return dominantIndex(numbers);
    }

    public int dominantIndex(int[] nums) {
        int[] best = {0, 0};
        int secondBest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > best[0]) {
                secondBest = best[0];
                best[0] = nums[i];
                best[1] = i;
            } else if (nums[i] > secondBest) {
                secondBest = nums[i];
            }
        }

        if (best[0] >= 2 * secondBest) return best[1];

        return -1;
    }
}
