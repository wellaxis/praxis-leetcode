package com.witalis.praxis.leetcode.task.h17.p1658.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1658
 * Name: Minimum Operations to Reduce X to Zero
 * URL: <a href="https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/">Minimum Operations to Reduce X to Zero</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int number;

    public Integer process() {
        return minOperations(numbers, number);
    }

    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int total = 0;
        int sum = 0;
        for (int i = 0; i < n; i++)
            total += nums[i];

        if (total < x) return -1;
        if (total == x) return n;

        total -= x;

        int s = 0;
        int e = 0;
        int len = 0;
        while (e < n) {
            sum += nums[e];
            while (sum > total) {
                sum = sum - nums[s];
                s++;
            }
            if (sum == total) {
                len = Math.max(len, (e - s + 1));
            }
            e++;
        }

        if (len == 0) return -1;

        return n - len;
    }
}
