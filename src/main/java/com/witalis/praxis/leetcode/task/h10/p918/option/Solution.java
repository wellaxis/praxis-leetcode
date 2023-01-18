package com.witalis.praxis.leetcode.task.h10.p918.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 918
 * Name: Maximum Sum Circular Subarray
 * URL: <a href="https://leetcode.com/problems/maximum-sum-circular-subarray/">Maximum Sum Circular Subarray</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return maxSubarraySumCircular(numbers);
    }

    // Kadane's algorithm
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0, curMin = 0, sum = 0, maxSum = nums[0], minSum = nums[0];
        for (int num : nums) {
            curMax = Math.max(curMax, 0) + num;
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin, 0) + num;
            minSum = Math.min(minSum, curMin);
            sum += num;
        }
        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}
