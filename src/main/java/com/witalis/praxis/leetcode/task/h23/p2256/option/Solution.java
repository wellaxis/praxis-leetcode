package com.witalis.praxis.leetcode.task.h23.p2256.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2256
 * Name: Minimum Average Difference
 * URL: <a href="https://leetcode.com/problems/minimum-average-difference/">Minimum Average Difference</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return minimumAverageDifference(numbers);
    }

    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int minAvgDiff = Integer.MAX_VALUE;
        long currPrefixSum = 0;

        long totalSum = 0;
        for (int index = 0; index < n; ++index) {
            totalSum += nums[index];
        }

        for (int index = 0; index < n; ++index) {
            currPrefixSum += nums[index];
            long leftPartAverage = currPrefixSum;
            leftPartAverage /= (index + 1);

            long rightPartAverage = totalSum - currPrefixSum;
            if (index != n - 1) {
                rightPartAverage /= (n - index - 1);
            }

            int currDifference = (int) Math.abs(leftPartAverage - rightPartAverage);
            if (currDifference < minAvgDiff) {
                minAvgDiff = currDifference;
                ans = index;
            }
        }

        return ans;
    }
}
