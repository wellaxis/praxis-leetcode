package com.witalis.praxis.leetcode.task.h17.p1688.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1688
 * Name: Count of Matches in Tournament
 * URL: <a href="https://leetcode.com/problems/count-of-matches-in-tournament/">Count of Matches in Tournament</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return numberOfMatches(number);
    }

    public int numberOfMatches(int n) {
        return n - 1;
    }
}
