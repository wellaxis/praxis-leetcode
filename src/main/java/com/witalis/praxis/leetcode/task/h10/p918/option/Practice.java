package com.witalis.praxis.leetcode.task.h10.p918.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 918
 * Name: Maximum Sum Circular Subarray
 * URL: <a href="https://leetcode.com/problems/maximum-sum-circular-subarray/">Maximum Sum Circular Subarray</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return maxSubarraySumCircular(numbers);
    }

    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        int maxSum = 0;
        for (int num : nums) {
            // total sum
            sum += num;
            // min sum
            minSum += num;
            min = Math.min(min, minSum);
            if (minSum > 0) minSum = 0;
            // max sum
            maxSum += num;
            max = Math.max(max, maxSum);
            if (maxSum < 0) maxSum = 0;
        }

        return (sum == min) ? max : Math.max(max, sum - min);
    }
}
