package com.witalis.praxis.leetcode.task.h23.p2256.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2256
 * Name: Minimum Average Difference
 * URL: <a href="https://leetcode.com/problems/minimum-average-difference/">Minimum Average Difference</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return minimumAverageDifference(numbers);
    }

    public int minimumAverageDifference(int[] nums) {
        return -1;
    }
}
