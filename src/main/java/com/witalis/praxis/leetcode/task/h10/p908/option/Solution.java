package com.witalis.praxis.leetcode.task.h10.p908.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 908
 * Name: Smallest Range I
 * URL: <a href="https://leetcode.com/problems/smallest-range-i/">Smallest Range I</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int element;

    public Integer process() {
        return smallestRangeI(numbers, element);
    }

    public int smallestRangeI(int[] nums, int k) {
        if (nums.length == 1) return 0;

        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (max < num) max = num;
            if (min > num) min = num;
        }

        return Math.max(max - min - 2 * k, 0);
    }
}
