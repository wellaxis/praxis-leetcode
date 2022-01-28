package com.witalis.praxis.leetcode.task.h1.p53.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 53
 * Name: Maximum Subarray
 * URL: https://leetcode.com/problems/maximum-subarray/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return maxSubArray(numbers);
    }

    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            result = Math.max(result, sum);
        }

        return result;
    }
}
