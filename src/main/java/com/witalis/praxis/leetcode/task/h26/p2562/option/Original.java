package com.witalis.praxis.leetcode.task.h26.p2562.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2562
 * Name: Find the Array Concatenation Value
 * URL: <a href="https://leetcode.com/problems/find-the-array-concatenation-value/">Find the Array Concatenation Value</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Long process() {
        return findTheArrayConcVal(numbers);
    }

    public long findTheArrayConcVal(int[] nums) {
        if (nums == null) return 0;

        int n = nums.length;
        long value = ((n & 1) != 0) ? nums[n / 2] : 0;
        for (int i = 0; i < n / 2; i++) {
            int l = nums[i];
            int r = nums[n - 1 - i];
            value += Long.parseLong(String.valueOf(l) + String.valueOf(r));
        }

        return value;
    }
}
