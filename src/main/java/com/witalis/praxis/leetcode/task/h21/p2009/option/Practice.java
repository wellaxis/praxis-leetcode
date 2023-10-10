package com.witalis.praxis.leetcode.task.h21.p2009.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2009
 * Name: Minimum Number of Operations to Make Array Continuous
 * URL: <a href="https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/">Minimum Number of Operations to Make Array Continuous</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return minOperations(numbers);
    }

    public int minOperations(int[] nums) {
        if (nums == null) return 0;

        final int n = nums.length;

        nums = Arrays.stream(nums).sorted().distinct().toArray();

        final int m = nums.length;

        int operations = n;
        for (int l = 0, r = 0; l < m; l++) {
            while (r < m && nums[r] < nums[l] + n) r++;
            operations = Math.min(operations, n - r + l);
        }

        return operations;
    }
}
