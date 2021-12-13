package com.witalis.praxis.leetcode.task.p53.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 53
 * Name: Maximum Subarray
 * URL: https://leetcode.com/problems/maximum-subarray/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return maxSubArray(numbers);
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;

        int sum = 0;
        for (int num : nums) {
            sum = Math.max(num, sum + num);
            max = Math.max(max, sum);
        }

        return max;
    }
}
