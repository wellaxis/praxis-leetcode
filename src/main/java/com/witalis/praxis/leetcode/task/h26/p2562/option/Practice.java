package com.witalis.praxis.leetcode.task.h26.p2562.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2562
 * Name: Find the Array Concatenation Value
 * URL: <a href="https://leetcode.com/problems/find-the-array-concatenation-value/">Find the Array Concatenation Value</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Long process() {
        return findTheArrayConcVal(numbers);
    }

    public long findTheArrayConcVal(int[] nums) {
        if (nums == null) return 0;

        final int n = nums.length;
        long value = ((n & 1) != 0) ? nums[n / 2] : 0;
        for (int i = 0; i < n / 2; i++) {
            int l = nums[i];
            int r = nums[n - 1 - i];

            value += r;
            while (r > 0) {
                l *= 10;
                r /= 10;
            }
            value += l;
        }

        return value;
    }
}
