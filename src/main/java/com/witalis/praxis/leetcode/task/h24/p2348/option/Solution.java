package com.witalis.praxis.leetcode.task.h24.p2348.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2348
 * Name: Number of Zero-Filled Subarrays
 * URL: <a href="https://leetcode.com/problems/number-of-zero-filled-subarrays/">Number of Zero-Filled Subarrays</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Long process() {
        return zeroFilledSubarray(numbers);
    }

    public long zeroFilledSubarray(int[] nums) {
        long count = 0;

        int n = nums.length;
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                j = i;
            } else {
                count += i - j;
            }
        }

        return count;
    }
}
