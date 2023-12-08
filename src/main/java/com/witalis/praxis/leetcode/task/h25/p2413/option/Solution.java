package com.witalis.praxis.leetcode.task.h25.p2413.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2413
 * Name: Smallest Even Multiple
 * URL: <a href="https://leetcode.com/problems/smallest-even-multiple/">Smallest Even Multiple</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return smallestEvenMultiple(number);
    }

    public int smallestEvenMultiple(int n) {
        return n * (n % 2 + 1);
    }
}
