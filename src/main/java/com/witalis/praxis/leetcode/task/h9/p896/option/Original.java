package com.witalis.praxis.leetcode.task.h9.p896.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 896
 * Name: Monotonic Array
 * URL: <a href="https://leetcode.com/problems/monotonic-array/">Monotonic Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Boolean process() {
        return isMonotonic(numbers);
    }

    enum Monotone {
        INCREASING,
        DECREASING
    }

    public boolean isMonotonic(int[] nums) {
        if (nums == null) return false;

        final int n = nums.length;

        Monotone monotone = null;
        int previous = nums[0];
        for (int i = 1; i < n; i++) {
            int current = nums[i];

            if (current == previous) continue;

            if (current > previous) {
                if (monotone == null) {
                    monotone = Monotone.INCREASING;
                } else {
                    if (monotone == Monotone.DECREASING) return false;
                }
            } else {
                if (monotone == null) {
                    monotone = Monotone.DECREASING;
                } else {
                    if (monotone == Monotone.INCREASING) return false;
                }
            }
            previous = current;
        }

        return true;
    }
}
