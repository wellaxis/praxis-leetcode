package com.witalis.praxis.leetcode.task.h10.p908.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * ID: 908
 * Name: Smallest Range I
 * URL: <a href="https://leetcode.com/problems/smallest-range-i/">Smallest Range I</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int element;

    public Integer process() {
        return smallestRangeI(numbers, element);
    }

    public int smallestRangeI(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return 0;

        final IntSummaryStatistics stats = Arrays.stream(nums).summaryStatistics();
        final int min = stats.getMin();
        final int max = stats.getMax();
        final int diff = max - min;

        return Math.max(0, diff - 2 * k);
    }
}
