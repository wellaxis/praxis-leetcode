package com.witalis.praxis.leetcode.task.h21.p2006.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2006
 * Name: Count Number of Pairs With Absolute Difference K
 * URL: <a href="https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/">Count Number of Pairs With Absolute Difference K</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int difference;

    public Integer process() {
        return countKDifference(numbers, difference);
    }

    public int countKDifference(int[] nums, int k) {
        final int kMax = 100;
        int ans = 0;
        int[] count = new int[kMax + 1];

        for (final int num : nums)
            ++count[num];

        for (int i = k + 1; i <= kMax; ++i)
            ans += count[i] * count[i - k];

        return ans;
    }
}
