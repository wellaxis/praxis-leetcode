package com.witalis.praxis.leetcode.task.h26.p2549.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2549
 * Name: Count Distinct Numbers on Board
 * URL: <a href="https://leetcode.com/problems/count-distinct-numbers-on-board/">Count Distinct Numbers on Board</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return distinctIntegers(number);
    }

    public int distinctIntegers(int n) {
        return Math.max(n - 1, 1);
    }
}
