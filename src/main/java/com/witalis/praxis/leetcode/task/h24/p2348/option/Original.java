package com.witalis.praxis.leetcode.task.h24.p2348.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2348
 * Name: Number of Zero-Filled Subarrays
 * URL: <a href="https://leetcode.com/problems/number-of-zero-filled-subarrays/">Number of Zero-Filled Subarrays</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Long process() {
        return zeroFilledSubarray(numbers);
    }

    public long zeroFilledSubarray(int[] nums) {
        if (nums == null) return 0L;

        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            long sequence = 0;
            while (i < nums.length && nums[i] == 0) {
                count += ++sequence;
                i++;
            }

        }

        return count;
    }
}
