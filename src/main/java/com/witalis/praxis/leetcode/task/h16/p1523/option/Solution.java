package com.witalis.praxis.leetcode.task.h16.p1523.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1523
 * Name: Count Odd Numbers in an Interval Range
 * URL: <a href="https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/">Count Odd Numbers in an Interval Range</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int low;
    private int high;

    public Integer process() {
        return countOdds(low, high);
    }

    public int countOdds(int low, int high) {
        // if low is even, make it odd.
        if ((low & 1) == 0) {
            low++;
        }

        // low could become greater than high due to incrementation
        // if it is, the answer is 0; otherwise, use the formula.
        return low > high ? 0 : (high - low) / 2 + 1;
    }
}
