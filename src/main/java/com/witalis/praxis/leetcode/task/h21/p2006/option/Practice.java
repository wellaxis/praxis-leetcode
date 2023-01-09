package com.witalis.praxis.leetcode.task.h21.p2006.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2006
 * Name: Count Number of Pairs With Absolute Difference K
 * URL: <a href="https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/">Count Number of Pairs With Absolute Difference K</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int difference;

    public Integer process() {
        return countKDifference(numbers, difference);
    }

    public static final int LEN = 100;

    public int countKDifference(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        final int[] frequencies = new int[LEN + 1];
        for (final int num : nums)
            frequencies[num]++;

        int count = 0;
        for (int i = 0; i + k <= LEN; i++)
            count += frequencies[i] * frequencies[i + k];

        return count;
    }
}
