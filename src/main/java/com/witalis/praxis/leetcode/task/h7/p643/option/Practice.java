package com.witalis.praxis.leetcode.task.h7.p643.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 643
 * Name: Maximum Average Subarray I
 * URL: <a href="https://leetcode.com/problems/maximum-average-subarray-i/">Maximum Average Subarray I</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int length;

    public Double process() {
        return findMaxAverage(numbers, length);
    }

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || k <= 0) return 0;

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            if (i == 0) {
                for (int j = 0; j < k; j++) sum += nums[j];
            } else {
                sum += nums[i + k - 1] - nums[i - 1];
            }
            max = Math.max(max, sum);
        }

        return (double) max / k;
    }
}
