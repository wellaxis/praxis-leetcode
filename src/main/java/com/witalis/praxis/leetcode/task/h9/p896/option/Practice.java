package com.witalis.praxis.leetcode.task.h9.p896.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 896
 * Name: Monotonic Array
 * URL: <a href="https://leetcode.com/problems/monotonic-array/">Monotonic Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Boolean process() {
        return isMonotonic(numbers);
    }

    public boolean isMonotonic(int[] nums) {
        if (nums == null) return false;

        final int n = nums.length;

        int monotonic = 0;
        int previous = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == previous) continue;

            if (nums[i] > previous) {
                if (monotonic == 0) {
                    monotonic = 1;
                } else {
                    if (monotonic == -1) return false;
                }
            } else {
                if (monotonic == 0) {
                    monotonic = -1;
                } else {
                    if (monotonic == 1) return false;
                }
            }
            previous = nums[i];
        }

        return true;
    }
}
