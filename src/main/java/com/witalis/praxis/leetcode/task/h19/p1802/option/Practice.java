package com.witalis.praxis.leetcode.task.h19.p1802.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1802
 * Name: Maximum Value at a Given Index in a Bounded Array
 * URL: <a href="https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/description/">Maximum Value at a Given Index in a Bounded Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int numbers;
    private int index;
    private int maxSum;

    public Integer process() {
        return maxValue(numbers, index, maxSum);
    }

    public int maxValue(int n, int index, int maxSum) {
        if (n < 0 || index < 0 || maxSum < 0) return 0;

        maxSum -= n;
        int l = 0;
        int r = maxSum;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (isPossible(mid, index, n, maxSum)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l + 1;
    }

    public boolean isPossible(int value, int index, int n, int sum) {
        long l = Math.max(value - index, 0);
        long r = Math.max(value - ((n - 1) - index), 0);

        long result = (value + l) * (value - l + 1) / 2 + (value + r) * (value - r + 1) / 2;

        return result - value <= sum;
    }
}
