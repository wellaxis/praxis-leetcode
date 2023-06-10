package com.witalis.praxis.leetcode.task.h19.p1802.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1802
 * Name: Maximum Value at a Given Index in a Bounded Array
 * URL: <a href="https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/description/">Maximum Value at a Given Index in a Bounded Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int numbers;
    private int index;
    private int maxSum;

    public Integer process() {
        return maxValue(numbers, index, maxSum);
    }

    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;

        int l = 0;
        int r = maxSum;

        while (l < r) {
            final int m = (l + r) / 2;
            if (getSum(n, index, m) >= maxSum)
                r = m;
            else
                l = m + 1;
        }

        return getSum(n, index, l) > maxSum ? l : l + 1;
    }

    private long getSum(int n, int index, int x) {
        long l = Math.min(index, x - 1);
        long r = Math.min(n - index, x);
        long lSum = ((x - 1) + (x - 1 - l + 1)) * l / 2;
        long rSum = (x + (x - r + 1)) * r / 2;

        return lSum + rSum;
    }
}
