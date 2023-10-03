package com.witalis.praxis.leetcode.task.h16.p1512.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1512
 * Name: Number of Good Pairs
 * URL: <a href="https://leetcode.com/problems/number-of-good-pairs/">Number of Good Pairs</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return numIdenticalPairs(numbers);
    }

    public int numIdenticalPairs(int[] nums) {
        final int MAX_VALUE = 100;
        final int[] frequencies = new int[MAX_VALUE + 1];

        int result = 0;
        for (int num : nums)
            result += frequencies[num]++;

        return result;
    }
}
