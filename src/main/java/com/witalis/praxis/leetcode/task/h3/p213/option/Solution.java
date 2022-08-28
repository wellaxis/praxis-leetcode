package com.witalis.praxis.leetcode.task.h3.p213.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 213
 * Name: House Robber II
 * URL: <a href="https://leetcode.com/problems/house-robber-ii/">House Robber II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return rob(numbers);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        return Math.max(
            robRange(nums, 1, nums.length - 1),
            nums[0] + robRange(nums, 2, nums.length - 2)
        );
    }

    public int robRange(int[] nums, int start, int end) {
        if (start > end) return 0;

        int max = 0;
        int noRob = 0;
        int rob = 0;
        for (int i = start; i <= end; i++) {
            int newNoRob = Math.max(rob, noRob);
            int newRob = noRob + nums[i];
            rob = newRob;
            noRob = newNoRob;
            max = Math.max(max, rob);
            max = Math.max(max, noRob);
        }

        return max;
    }
}
