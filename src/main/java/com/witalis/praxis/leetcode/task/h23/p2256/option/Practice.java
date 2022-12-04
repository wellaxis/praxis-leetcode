package com.witalis.praxis.leetcode.task.h23.p2256.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * ID: 2256
 * Name: Minimum Average Difference
 * URL: <a href="https://leetcode.com/problems/minimum-average-difference/">Minimum Average Difference</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return minimumAverageDifference(numbers);
    }

    public int minimumAverageDifference(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int index = -1;

        int len = nums.length;
        long sum = 0;
        for (int num : nums) sum += num;

        long currentSum = 0;
        long minDifference = Long.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            currentSum += nums[i];
            int difference = (int) Math.abs(currentSum / (i + 1) - (sum - currentSum) / (len - i - 1));
            if (difference < minDifference) {
                minDifference = difference;
                index = i;
            }
        }
        if (minDifference > sum / len) index = len - 1;

        return index;
    }
}
