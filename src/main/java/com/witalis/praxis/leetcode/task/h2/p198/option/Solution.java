package com.witalis.praxis.leetcode.task.h2.p198.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 198
 * Name: House Robber
 * URL: <a href="https://leetcode.com/problems/house-robber/">House Robber</a>
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
        int preRob = 0;
        int preMiss = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = preRob;
            preRob = preMiss + nums[i];
            preMiss = Math.max(temp, preMiss);

        }
        return Math.max(preRob, preMiss);
    }
}
