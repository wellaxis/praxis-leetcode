package com.witalis.praxis.leetcode.task.h7.p674.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 674
 * Name: Longest Continuous Increasing Subsequence
 * URL: <a href="https://leetcode.com/problems/longest-continuous-increasing-subsequence/">Longest Continuous Increasing Subsequence</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return findLengthOfLCIS(numbers);
    }

    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int c = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                c++;
                max = Math.max(c, max);
            } else {
                c = 1;
            }
        }

        return max;
    }
}
