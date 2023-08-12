package com.witalis.praxis.leetcode.task.h5.p413.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 413
 * Name: Arithmetic Slices
 * URL: <a href="https://leetcode.com/problems/arithmetic-slices/">Arithmetic Slices</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return numberOfArithmeticSlices(numbers);
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int dp = 0;

        for (int i = 2; i < nums.length; ++i) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2])
                ans += ++dp;
            else
                dp = 0;
        }

        return ans;
    }
}
