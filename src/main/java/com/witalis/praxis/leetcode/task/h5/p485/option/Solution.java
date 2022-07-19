package com.witalis.praxis.leetcode.task.h5.p485.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 485
 * Name: Max Consecutive Ones
 * URL: <a href="https://leetcode.com/problems/max-consecutive-ones/">Max Consecutive Ones</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return findMaxConsecutiveOnes(numbers);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int max = 0;
        for (int i : nums) {
            if (i == 1) {
                ans++;
            } else if (i == 0) {
                max = Math.max(max, ans);
                ans = 0;
            }
        }
        max = Math.max(max, ans);

        return max;
    }
}
