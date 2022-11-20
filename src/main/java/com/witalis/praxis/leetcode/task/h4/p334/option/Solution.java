package com.witalis.praxis.leetcode.task.h4.p334.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 334
 * Name: Increasing Triplet Subsequence
 * URL: <a href="https://leetcode.com/problems/increasing-triplet-subsequence/">Increasing Triplet Subsequence</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Boolean process() {
        return increasingTriplet(numbers);
    }

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (final int num : nums)
            if (num <= first)
                first = num;
            else if (num <= second)
                second = num;
            else
                return true;

        return false;
    }
}
