package com.witalis.praxis.leetcode.task.h7.p643.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 643
 * Name: Maximum Average Subarray I
 * URL: <a href="https://leetcode.com/problems/maximum-average-subarray-i/">Maximum Average Subarray I</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int length;

    public Double process() {
        return findMaxAverage(numbers, length);
    }

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        for (int i = 0; i < k; i++) sum += nums[i];

        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }

        return res / k;
    }
}
