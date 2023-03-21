package com.witalis.praxis.leetcode.task.h24.p2348.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2348
 * Name: Number of Zero-Filled Subarrays
 * URL: <a href="https://leetcode.com/problems/number-of-zero-filled-subarrays/">Number of Zero-Filled Subarrays</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Long process() {
        return zeroFilledSubarray(numbers);
    }

    public long zeroFilledSubarray(int[] nums) {
        if (nums == null) return 0L;

        long count = 0;
        long sequence = 0;
        for (final int num : nums) {
            if (num == 0) {
                sequence++;
                count += sequence;
            } else {
                sequence = 0;
            }
        }

        return count;
    }
}
