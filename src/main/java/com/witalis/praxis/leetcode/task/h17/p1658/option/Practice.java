package com.witalis.praxis.leetcode.task.h17.p1658.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1658
 * Name: Minimum Operations to Reduce X to Zero
 * URL: <a href="https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/">Minimum Operations to Reduce X to Zero</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int number;

    public Integer process() {
        return minOperations(numbers, number);
    }

    public int minOperations(int[] nums, int x) {
        if (nums == null || x < 0) return -1;

        final int n = nums.length;

        final int total = Arrays.stream(nums).sum();
        final int difference = total - x;

        if (difference < 0) return -1;
        if (difference == 0) return n;

        int minOperations = Integer.MAX_VALUE;

        int sum = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            sum += nums[right++];

            while (sum > difference && left < n)
                sum -= nums[left++];

            if (sum == difference)
                minOperations = Math.min(minOperations, n - (right - left));
        }

        return minOperations == Integer.MAX_VALUE ? -1 : minOperations;
    }
}
